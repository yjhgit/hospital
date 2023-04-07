package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ReservationDotMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ReservationDotService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (ReservationDot)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
@Service("reservationDotService")
public class ReservationDotServiceImpl extends ServiceImpl<ReservationDotMapper, ReservationDot> implements ReservationDotService {

    @Autowired
    private ReservationDotMapper reservationDotMapper;
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Override
    public Integer addReYs(ReservationDot reservationDot) {
        synchronized (this){
            Schedule schedule = new Schedule();
            schedule.setDoctorId(reservationDot.getDoctorId());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                schedule.setBookingTime(format.parse(reservationDot.getReservationTime()));
            } catch (Exception e) {
                log.error("时间转换异常");
            }
            schedule.setTimePeriod(reservationDot.getTimePeriod());
            Schedule scheduleResult = scheduleService.queryScheduleByTime(schedule);
            if(StringUtils.isNotEmpty(scheduleResult) && scheduleResult.getSignalSource() > 0 && scheduleResult.getSignalSource() > 0){
                // 排期扣次
                scheduleResult.setSignalSource(scheduleResult.getSignalSource() - 1);
                // 判断排期是否存在，不存在新增 存在修改
                if(StringUtils.isEmpty(scheduleResult.getCreateTime())){
                    scheduleResult.setCreateTime(new Date());
                    scheduleService.insert(scheduleResult);
                }
                scheduleService.updateSchedule(scheduleResult);
                reservationDotMapper.insert(reservationDot);
                return 1;
            }
        }
        return null;
    }

    @Override
    public List<ReservationDot> findByMyId(String id) {
        return lambdaQuery()
                .eq(ReservationDot::getUserId,id)
                .list();
    }

    @Override
    public List<ReservationDot> findAllByAdmin() {
        return lambdaQuery()
                .orderByDesc(ReservationDot::getReservationTime)
                .list();
    }

    @Override
    public List<ReservationDot> findAllByAdmin(String name) {
        return lambdaQuery()
                .like(ReservationDot::getName,name)
                .list();
    }

    @Override
    public void cancel(Integer id) {
        ReservationDot reservationDot = reservationDotMapper.selectById(id);
        Schedule schedule = new Schedule();
        schedule.setDoctorId(reservationDot.getDoctorId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            schedule.setBookingTime(format.parse(reservationDot.getReservationTime()));
        } catch (Exception e) {
            log.error("时间转换异常");
        }
        schedule.setTimePeriod(reservationDot.getTimePeriod());
        Schedule scheduleResult = scheduleService.queryScheduleByTime(schedule);
        Schedule scheduleParam = new Schedule();
        scheduleParam.setId(scheduleResult.getId());
        scheduleParam.setSignalSource(scheduleResult.getSignalSource() + 1);
        // 排期返还
        scheduleService.updateById(scheduleParam);
        ReservationDot dot = new ReservationDot();
        dot.setId(id);
        dot.setState(0);
        reservationDotMapper.updateById(dot);
    }
}

