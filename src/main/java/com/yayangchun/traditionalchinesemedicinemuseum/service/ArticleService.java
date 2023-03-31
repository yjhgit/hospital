package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author 崖洋春
 * @since 2023-03-19 00:00:30
 */
public interface ArticleService extends IService<Article> {

    public List<Article> findAll();

    public List<Article> findByTitle(String title);

    public Integer addInformation(Article article);

    public Integer delAllInFor(String id);

    public boolean delById(String id);

    public Integer updateInformationById(Article article);


    public Integer collection(String userid, String acid);

    public Integer selecollection(String userid, String acid);

    public List<Integer> seleByacid( String userid);

}

