package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


/**
 * (ReservationDot)表数据库访问层
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {

    @Update("update schedule set signal_source = #{signalSource} where doctor_id = #{doctorId}")
    void updateScheduleByDoctorId(Schedule scheduleResult);
}

