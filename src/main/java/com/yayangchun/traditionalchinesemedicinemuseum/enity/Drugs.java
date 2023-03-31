package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * (Drugs)表实体类
 *
 * @author 崖洋春
 * @since 2023-03-19 20:02:46
 */
@Data
@TableName("drugs")
public class Drugs extends Model<Drugs> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String name;
    /**
     * 药材封面
     */
    private String drugsImg;
    /**
     * 药材简介
     */
    private String synopsis;
    /**
     * 药材详情
     */
    private String drugsInfo;
    /**
     * 录入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

}

