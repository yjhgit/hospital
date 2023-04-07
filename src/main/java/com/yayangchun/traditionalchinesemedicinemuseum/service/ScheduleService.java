package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface ScheduleService extends IService<Schedule> {


    List<Schedule> queryScheduleById(Integer userId);

    Schedule queryScheduleByTime(Schedule schedule);

    void updateSchedule(Schedule scheduleResult);

    void insert(Schedule scheduleResult);
}

