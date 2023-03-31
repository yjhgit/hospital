package com.yayangchun.traditionalchinesemedicinemuseum.controller.reception;

import com.yayangchun.traditionalchinesemedicinemuseum.enity.Propose;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationYc;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoEditDto;
import com.yayangchun.traditionalchinesemedicinemuseum.service.*;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：崖洋春
 * 时间：2023/3/17 15:13
 **/
@RestController
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

    @RequestMapping("/upDataByUserInfo")
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
     * 留言
     * @param propose
     * @return
     */
    @RequestMapping("/addMsg")
    public ResultUtil addMsg(Propose propose){
        Integer integer = proposeService.addPropose(propose);
        if (integer==0){
            return ResultUtil.fail(500,"建议失败");
        }

        return ResultUtil.success("添加成功");
    }

    /**
     * 添加煎药预约
     * @param reservationYc
     * @return
     */
    @RequestMapping("/addJy")
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
    public ResultUtil addYYs(ReservationDot reservationDot){
        Integer integer = reservationDotService.addReYs(reservationDot);
        if (integer==0){
            return ResultUtil.fail(500,"添加失败");
        }
        return ResultUtil.success("添加成功");
    }


}
