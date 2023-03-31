package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@TableName("sw.user_info_address")
@Data
public class UserInfoAddress {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String provName;

    private String cityName;

    private String areaName;

    private String address;

    private Integer userInfoId;

}
