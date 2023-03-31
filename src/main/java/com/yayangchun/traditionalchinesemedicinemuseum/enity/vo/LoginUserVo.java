package com.yayangchun.traditionalchinesemedicinemuseum.enity.vo;


import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@Data
public class LoginUserVo {

    private Integer id;

    private String account;

    private Integer power;

    private String status;

    private UserInfo userInfo;
}
