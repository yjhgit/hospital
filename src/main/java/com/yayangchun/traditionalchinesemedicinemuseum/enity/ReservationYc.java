package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (ReservationYc)表实体类
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:55
 */
@Data
@TableName("reservation_yc")
public class ReservationYc extends Model<ReservationYc> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 预约人姓名
     */
    private String name;
    /**
     * 预约手机号
     */
    private String phone;
    /**
     * 预约时间
     */
    private String time;

    private String userId;

}

