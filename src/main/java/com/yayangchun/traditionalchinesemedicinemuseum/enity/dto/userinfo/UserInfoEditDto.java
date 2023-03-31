package com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo;

import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/11 17:16
 **/
@Data
public class UserInfoEditDto {
    private Integer id;

    private String username;

    private String sex;

    private Integer age;

    private double height;

    private double weight;

    private Integer addressId;

    private String phone;

    private Integer userId;
}
