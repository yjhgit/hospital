package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * (Article)表实体类
 *
 * @author 崖洋春
 * @since 2023-03-19 00:00:29
 */
@Data
@TableName("article")
public class Article extends Model<Article> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章封面
     */
    private String articleImg;
    /**
     * 文章内容
     */
    private String articleText;
    /**
     * 添加事件
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    /**
     * 文章作者
     */
    private String articleAuthor;
    /**
     * 更新时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}

