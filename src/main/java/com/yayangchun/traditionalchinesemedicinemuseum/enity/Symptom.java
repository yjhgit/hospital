package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @date 2023-04-07
 */
@Data
@TableName("Symptom")
public class Symptom implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

}
