package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (ReservationDot)表实体类
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
@Data
@TableName("reservation_dot")
public class ReservationDot extends Model<ReservationDot> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 预约的医生名
     */
    private String reservationName;
    /**
     * 症状
     */
    private String symptom;
    /**
     * 预约时间
     */
    private String reservationTime;
    /**
     * 预约时段
     */
    private String timePeriod;
    /**
     * 预约人年龄
     */
    private String reservationAge;
    /**
     * 预留电话
     */
    private String reservationPhone;
    /**
     * 预约人的姓名
     */
    private String name;

    private Integer userId;
    /**
     * 预约状态 0已取消 1已预约 2已完成
     */
    private Integer state;

    private Integer doctorId;

}

