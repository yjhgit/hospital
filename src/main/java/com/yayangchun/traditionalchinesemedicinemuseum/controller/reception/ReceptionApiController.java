package com.yayangchun.traditionalchinesemedicinemuseum.controller.reception;

import com.yayangchun.traditionalchinesemedicinemuseum.dao.ArticleMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Propose;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationYc;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoEditDto;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginUserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.*;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.SecurityUnit;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.StringUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：崖洋春
 * 时间：2023/3/17 15:13
 **/
@Controller
@RequestMapping("/receptionApi")
public class ReceptionApiController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ArticleService articleService;

    @Autowired
    ProposeService proposeService;

    @Autowired
    ReservationYcService reservationYcService;

    @Autowired
    ReservationDotService reservationDotService;

    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/upDataByUserInfo")
    @ResponseBody
    public ResultUtil upDataByUserInfo(UserInfo editDto){
        Integer integer = userInfoService.upUserInfo(editDto);
        if (integer==0){
            return ResultUtil.fail("修改失败");
        }

        return ResultUtil.success("修改成功");
    }

    /**
     * 收藏
     * @param userid
     * @param acid
     * @return
     */
    @RequestMapping("/collectionByUser")
    @ResponseBody
    public ResultUtil collectionByUser(String userid, String acid){
        Integer selecollection = articleService.selecollection(userid, acid);
        if (selecollection!=0){
          return  ResultUtil.fail(500,"收藏失败");
        }
        Integer collection = articleService.collection(userid, acid);
        if (collection==0){
          return   ResultUtil.fail(500,"收藏失败");
        }
        return ResultUtil.success("收藏成功");
    }

    /**
     * @description: 取消收藏
     * @date 2023/4/7
     */
    @RequestMapping("/deleteCollect")
    @ResponseBody
    public ResultUtil deleteCollect(Integer id){
        articleMapper.delCollection(id);
        return ResultUtil.success("取消收藏成功");
    }

    /**
     * 留言
     * @param propose
     * @return
     */
    @RequestMapping("/addMsg")
    @ResponseBody
    public ResultUtil addMsg(Propose propose){
        Integer integer = proposeService.addPropose(propose);
        if (integer==0){
            return ResultUtil.fail(500,"建议失败");
        }

        return ResultUtil.success("添加成功");
    }

    /**
     * 删除留言
     * @return
     */
    @RequestMapping("/deleteMsg")
    @ResponseBody
    public ResultUtil deleteMsg(Integer id){
        proposeService.removeById(id);
        return ResultUtil.success("删除成功");
    }

    /**
     * 添加煎药预约
     * @param reservationYc
     * @return
     */
    @RequestMapping("/addJy")
    @ResponseBody
    public ResultUtil addJy(ReservationYc reservationYc){
        Integer integer = reservationYcService.addYc(reservationYc);

        if (integer==0){
            return ResultUtil.fail(500,"添加失败");
        }
        return ResultUtil.success("添加成功");

    }

    /**
     * 添加面诊预约
     * @param reservationDot
     * @return
     */
    @RequestMapping("/addYYs")
    public String addYYs(ReservationDot reservationDot){
        LoginUserVo vo = SecurityUnit.getLoginInfo();
        reservationDot.setUserId(vo.getId());
        reservationDot.setName(vo.getUserInfo().getUsername());
        reservationDot.setReservationAge(StringUtils.isEmpty(vo.getUserInfo().getAge())?"":vo.getUserInfo().getAge().toString());
        reservationDot.setReservationPhone(vo.getUserInfo().getPhone());
        reservationDot.setState(1);
        reservationDotService.addReYs(reservationDot);
        return "redirect:/reception/toMyReserve?id="+vo.getId();
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public ResultUtil cancel(Integer id){
        reservationDotService.cancel(id);
        return ResultUtil.success("取消成功");
    }


}
