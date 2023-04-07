package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

/**
 * @date 2023-04-04
 */
@Data
@TableName("schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @Column("id")
    private Integer id;

    /**
     * 医生id
     */
    @Column("doctor_id")
    private Integer doctorId;

    /**
     * 状态 1、不可约
     */
    @Column("status")
    private Integer status;

    /**
     * 时段
     */
    @Column("time_period")
    private String timePeriod;

    /**
     * 剩余号源
     */
    @Column("signal_source")
    private Integer signalSource;

    /**
     * 默认号源
     */
    @Column("default_source")
    private Integer defaultSource;

    /**
     * 预约时间
     */
    @Column("booking_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingTime;

    /**
     * 创建时间
     */
    @Column("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @TableField(exist = false)
    private String bookingTimeStr;

    @TableField(exist = false)
    private List<Schedule> timePeriodList;


}
