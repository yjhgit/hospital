package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

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

    @Column("department_id")
    private Integer departmentId;

    @Column("working_date")
    private String workingDate;

    @Column("signal_source")
    private Integer signalSource;

    @TableField(exist = false)
    private String username;

}

