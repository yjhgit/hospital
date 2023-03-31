package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@TableName("user")
@Data
public class User {
    @TableId( type = IdType.AUTO)
    private Integer id;
    
    private String account;
    
    private String password;
    
    private Integer power;

    private String role;

    private String uuid;

    private String status;


    }

