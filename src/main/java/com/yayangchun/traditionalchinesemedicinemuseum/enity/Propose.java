package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * (Propose)表实体类
 *
 * @author 崖洋春
 * @since 2023-03-19 16:21:38
 */
@Data
@TableName("propose")
public class Propose extends Model<Propose> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 留言姓名
     */
    private String name;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 留言主题
     */
    private String subject;
    /**
     * 留言信息
     */
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;

    private String userId;

}

