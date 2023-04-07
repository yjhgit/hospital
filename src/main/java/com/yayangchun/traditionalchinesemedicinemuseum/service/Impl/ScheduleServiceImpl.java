package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.constant.CommonConstant;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ScheduleMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ScheduleService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Service
@Slf4j
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<Schedule> queryScheduleById(Integer userId) {
        List<Schedule> listDay = new ArrayList<>();
        try {
            List<Schedule> list = lambdaQuery().eq(Schedule::getDoctorId, userId).list();
            User user = userService.findById(userId);
            // 默认30天内的日期
            List<String> everyDay = findEveryDay(30,user.getWorkingDate());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 1; i < everyDay.size(); i++) {
                Schedule scheduleAll = new Schedule();
                scheduleAll.setBookingTimeStr(everyDay.get(i));
                scheduleAll.setTimePeriodList(new ArrayList<>());
                List<Schedule> scheduleList = new ArrayList<>();
                for (Schedule schedule : list) {
                    Date bookingTime = schedule.getBookingTime();
                    if(StringUtils.isNotEmpty(bookingTime) && everyDay.get(i).equals(sdf.format(bookingTime))){
                        scheduleList.add(schedule);
                    }
                }
                if(StringUtils.isEmpty(scheduleList)){
                    Schedule scheduleWay = new Schedule();
                    scheduleWay.setBookingTime(new SimpleDateFormat("yyyy-MM-dd").parse(everyDay.get(i)));
                    scheduleList.add(scheduleWay);
                }
                List<String> TimePeriodList = JSON.parseArray(CommonConstant.TIME_PERIOD_LIST, String.class);
                TimePeriodList.forEach(timePeriod->{
                    Schedule scheduleWay = null;
                    for (Schedule schedule : scheduleList) {
                        if(StringUtils.isNotEmpty(schedule) && timePeriod.equals(schedule.getTimePeriod())){
                            scheduleWay = schedule;
                        }
                    }
                    // 如果库里没有排期，这里模拟一天排期，号源没配置的情况，这里默认5个号源
                    if(StringUtils.isEmpty(scheduleWay)){
                        scheduleWay = new Schedule();
                        scheduleWay.setTimePeriod(timePeriod);
                        if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(user.getSignalSource())){
                            scheduleWay.setSignalSource(user.getSignalSource());
                        }else {
                            scheduleWay.setSignalSource(CommonConstant.DEFAULT_SIGNAL_SOURCE);
                        }
                    }
                    scheduleAll.getTimePeriodList().add(scheduleWay);
                });
                Integer num = 0;
                for (Schedule schedule : scheduleAll.getTimePeriodList()) {
                    num += schedule.getSignalSource();
                }
                scheduleAll.setSignalSource(num);
                listDay.add(scheduleAll);
            }
        }catch (Exception e){
            log.error("处理排期数据错误{}",e);
        }
        return listDay;
    }

    @Override
    public Schedule queryScheduleByTime(Schedule scheduleParam) {
        Schedule schedule = lambdaQuery()
                .eq(Schedule::getDoctorId, scheduleParam.getDoctorId())
                .eq(Schedule::getBookingTime, scheduleParam.getBookingTime())
                .eq(Schedule::getTimePeriod, scheduleParam.getTimePeriod())
                .one();

        if(StringUtils.isEmpty(schedule)){
            schedule = scheduleParam;
            User user = userService.findById(scheduleParam.getDoctorId());
            if(StringUtils.isNotEmpty(user)){
                schedule.setSignalSource(user.getSignalSource());
            }else {
                schedule.setSignalSource(CommonConstant.DEFAULT_SIGNAL_SOURCE);
            }
        }
        return schedule;
    }

    @Override
    public void updateSchedule(Schedule scheduleResult) {
        scheduleMapper.updateById(scheduleResult);
    }

    @Override
    public void updateScheduleByDoctorId(Schedule scheduleResult) {
        scheduleMapper.updateScheduleByDoctorId(scheduleResult);
    }

    @Override
    public void insert(Schedule scheduleResult) {
        scheduleMapper.insert(scheduleResult);
    }

    /**
     * 获取 指定天数后的日期集合
     * @return
     * @throws ParseException
     */
    public static List<String> findEveryDay(Integer num,String workingDate) {
        List<Integer> dayList = new ArrayList<>();
        if(StringUtils.isNotEmpty(workingDate)){
            String[] split = workingDate.split(",");
            for (String s : split) {
                dayList.add(conversionTime(s));
            }
        }
        //1.创建一个放所有日期的集合
        List<String> dates = new ArrayList();
        //2.创建时间解析对象规定解析格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        Date dBegin = new Date();
        Date dEnd = cal.getTime();
        //4.将格式化后的第一天添加进集合
        dates.add(sdf.format(dBegin));
        //5.使用本地的时区和区域获取日历
        Calendar calBegin = Calendar.getInstance();
        //6.传入起始时间将此日历设置为起始日历
        calBegin.setTime(dBegin);
        //8.判断结束日期是否在起始日历的日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 9.根据日历的规则:月份中的每一天，为起始日历加一天
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            //10. 判断循环的日期是否是医生配置的工作日如果是就放到集合里
            if(StringUtils.isEmpty(dayList) || (StringUtils.isNotEmpty(dayList) && dayList.contains(calBegin.get(Calendar.DAY_OF_WEEK)-1))){
                dates.add(sdf.format(calBegin.getTime()));
            }
            //11.如果当前的起始日历超过结束日期后,就结束循环
        }
        return dates;
    }

    /**
     * @description: 日期转换
     * @date 2023/4/7
     */
    public static Integer conversionTime(String day) {
        Integer dayDesc = null;
        if (day != null) {
            switch (day) {
                case "周一":
                    dayDesc = 1;
                    break;
                case "周二":
                    dayDesc = 2;
                    break;
                case "周三":
                    dayDesc = 3;
                    break;
                case "周四":
                    dayDesc = 4;
                    break;
                case "周五":
                    dayDesc = 5;
                    break;
                case "周六":
                    dayDesc = 6;
                    break;
                case "周日":
                    dayDesc = 0;
                    break;
                default:
                    log.error("日期转换异常，请查看后台日期配置");
            }
        }
        return dayDesc;
    }
}

