package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ArticleMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Article;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 00:00:30
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<Article> findAll() {
        return lambdaQuery()
                .list();
    }

    @Override
    public List<Article> findByTitle(String title) {
        return lambdaQuery()
                .like(Article::getArticleTitle,title)
                .list();
    }

    @Override
    public Integer addInformation(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public boolean delById(String id) {
        return removeById(id);
    }

    @Override
    public Integer updateInformationById(Article article) {
        return articleMapper.updateById(article);
    }

    @Override
    public Integer collection(String userid, String acid) {
        return articleMapper.collection(userid,acid);
    }

    @Override
    public Integer selecollection(String userid, String acid) {
        return articleMapper.selecollection(userid,acid);
    }

    @Override
    public List<Integer> seleByacid(String userid) {
        return articleMapper.seleByacid(userid);
    }

    @Override
    public Integer delAllInFor(String id) {
        return articleMapper.delAllInFor(id);
    }
}

