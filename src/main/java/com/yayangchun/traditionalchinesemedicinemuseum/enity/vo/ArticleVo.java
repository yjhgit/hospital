package com.yayangchun.traditionalchinesemedicinemuseum.enity.vo;

import com.yayangchun.traditionalchinesemedicinemuseum.enity.Article;
import lombok.Data;

import java.util.Date;

/**
 * 作者：崖洋春
 * 时间：2023/3/19 2:01
 **/
@Data
public class ArticleVo extends Article {

    private String href;

    private String addTimeVo;

    private String updateTimeVo;
}
