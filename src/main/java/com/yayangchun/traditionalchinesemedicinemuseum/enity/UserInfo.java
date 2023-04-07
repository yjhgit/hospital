package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023-03-09 18:01:00
 */
@TableName("user_info")
@Data
public class UserInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String sex;

    private Integer age;

    private double height;

    private double weight;

    private Integer addressId;

    private String phone;

    private String introduce;

    private String img;

    private Integer userId;




}

