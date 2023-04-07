package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


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

    @Delete("delete from collect where id = #{id}")
    void delCollection(@Param("id") Integer id);

    public Integer selecollection(@Param("userid") String userid,@Param("acid") String acid);

    public List<Map<String,Integer>> seleByacid(@Param("userid") String userid);



}

