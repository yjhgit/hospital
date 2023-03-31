package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (Article)表数据库访问层
 *
 * @author 崖洋春
 * @since 2023-03-19 00:00:25
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    public Integer delAllInFor(String id);

    public Integer collection(@Param("userid") String userid,@Param("acid") String acid);

    public Integer selecollection(@Param("userid") String userid,@Param("acid") String acid);

    public List<Integer> seleByacid(@Param("userid") String userid);



}

