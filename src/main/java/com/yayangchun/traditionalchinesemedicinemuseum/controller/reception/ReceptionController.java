package com.yayangchun.traditionalchinesemedicinemuseum.controller.reception;

import cn.hutool.core.bean.BeanUtil;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.*;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.ArticleVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.DrugsVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/11 21:14
 **/
@Controller
@RequestMapping("/reception")
public class ReceptionController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ProposeService proposeService;

    @Autowired
    private DrugsService drugsService;

    @Autowired
    ReservationYcService reservationYcService;

    @Autowired
    ReservationDotService reservationDotService;

    @RequestMapping("/toIndex")
    public String toIndex(){return "/reception/doc/home";}

    @RequestMapping("/chat")
    public String chat(){return "/reception/chat-01";}

    @RequestMapping("/toPassword")
    public String toPassword(){
        return "/reception/doc/info/password-edit";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "/reception/doc/info/user-setting";
    }


    @RequestMapping("/toForum")
    public String toForum(Model model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Article> all = articleService.findAll();
        List<ArticleVo> articleVos = new ArrayList<>();
        all.forEach(v->{
            ArticleVo articleVo = new ArticleVo();
            articleVo.setArticleTitle(v.getArticleTitle());
            articleVo.setArticleAuthor(v.getArticleAuthor());
            if (v.getArticleText().length()>100){
                articleVo.setArticleText(v.getArticleText().substring(0,100));
            }else {
                articleVo.setArticleText(v.getArticleText());
            }
            articleVo.setAddTimeVo(simpleDateFormat.format(v.getAddTime()));
            articleVo.setUpdateTimeVo(simpleDateFormat.format(v.getUpdateTime()));
            if (v.getArticleImg()==null){
                articleVo.setArticleImg("#");
            }else {
                articleVo.setArticleImg(v.getArticleImg());
            }
            articleVo.setHref("/reception/toForumInfo?id="+v.getId());
            articleVos.add(articleVo);

        });
        model.addAttribute("list",articleVos);
        return "/reception/doc/blog-05";
    }

    @RequestMapping("/toForumByMy")
    public String toForumByMy(Model model,String id){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Integer> integers = articleService.seleByacid(id);
        List<Article> all = articleService.lambdaQuery().in(Article::getId,integers).list();
        List<ArticleVo> articleVos = new ArrayList<>();
        all.forEach(v->{
            ArticleVo articleVo = new ArticleVo();
            articleVo.setArticleTitle(v.getArticleTitle());
            articleVo.setArticleAuthor(v.getArticleAuthor());
            if (v.getArticleText().length()>100){
                articleVo.setArticleText(v.getArticleText().substring(0,100));
            }else {
                articleVo.setArticleText(v.getArticleText());
            }
            articleVo.setAddTimeVo(simpleDateFormat.format(v.getAddTime()));
            articleVo.setUpdateTimeVo(simpleDateFormat.format(v.getUpdateTime()));
            if (v.getArticleImg()==null){
                articleVo.setArticleImg("#");
            }else {
                articleVo.setArticleImg(v.getArticleImg());
            }
            articleVo.setHref("/reception/toForumInfo?id="+v.getId());
            articleVos.add(articleVo);

        });
        model.addAttribute("list",articleVos);
        return "/reception/doc/blog-666";
    }

    @RequestMapping("/toForumInfo")
    public String toForumInfo(String id,Model model){
        Article one = articleService.lambdaQuery().eq(Article::getId, id).one();
        model.addAttribute("articleTitle",one.getArticleTitle());
        model.addAttribute("articleText",one.getArticleText());
        model.addAttribute("id",one.getId());
        return "/reception/doc/blog_single-03";
    }

    @RequestMapping("/about")
    public String toAbout(){
        return "/reception/doc/about";
    }

    @RequestMapping("/toMyProposal")
    public String toMyProposal(String id,Model model){
        List<Propose> byUserid = proposeService.findByUserid(id);
        model.addAttribute("list",byUserid);
        return "/reception/doc/papa";
    }

    /**
     * 专家名录
     */
    @RequestMapping("/expert")
    public String expert(){
        return "/reception/doc/ml";
    }

    @RequestMapping("/Department")
    public String Department(){
        return "/reception/doc/ks";
    }

    /**
     * 道地药材
     * @param model
     * @return
     */
    @RequestMapping("/toDrugs")
    public String toDrugs(Model model){
        List<Drugs> all = drugsService.findAll();
        List<DrugsVo> vos = new ArrayList<>();

        all.forEach(v->{
            DrugsVo drugsVo = new DrugsVo();
            BeanUtil.copyProperties(v,drugsVo);
            drugsVo.setHref("/reception/toDrugsInfo?id="+v.getId());
            vos.add(drugsVo);
        });
        model.addAttribute("list",vos);
        return "/reception/doc/yc";
    }

    /**
     * 药材详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toDrugsInfo")
    public String toDrugsInfo(Model model,String id){
        Drugs one = drugsService.lambdaQuery().eq(Drugs::getId, id).one();
        model.addAttribute("name",one.getName());
        model.addAttribute("drugsInfo",one.getDrugsInfo());
        return "/reception/doc/ycinfo";
    }

    /**
     * 预约煎药
     * @return
     */
    @RequestMapping("/toreYc")
    public String toreYc(){
        return "/reception/doc/jy";
    }

    /**
     * 预约面诊
     * @return
     */
    @RequestMapping("/toreYs")
    public String toreYs(){
        return "/reception/doc/ys";
    }

    @RequestMapping("/toMyReserve")
    public String toMyReserve(Model model,String id){
        List<ReservationDot> byMyId = reservationDotService.findByMyId(id);
        List<ReservationYc> byMyId1 = reservationYcService.findByMyId(id);
        model.addAttribute("dot",byMyId);
        model.addAttribute("yc",byMyId1);
        return "/reception/doc/service-02";
    }
}
