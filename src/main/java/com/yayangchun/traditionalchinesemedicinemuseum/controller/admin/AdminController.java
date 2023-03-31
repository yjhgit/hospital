package com.yayangchun.traditionalchinesemedicinemuseum.controller.admin;

import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 作者：崖洋春
 * 时间：2023/3/18 20:21
 **/
@Controller
@RequestMapping("/adminPage")
public class AdminController extends BaseController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/admin/index";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/upPassword")
    public String upPassword(){
        return "/admin/member-password";
    }

    @RequestMapping("/toMemberList")
    public String toMemberList(){
        return "/admin/member/member-list";
    }

    @RequestMapping("/toMemberDelList")
    public String toMemberDelList(){
        return "/admin/member/member-del-list";
    }

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "/admin/user/user-list";
    }

    @RequestMapping("/toUserEdit")
    public String toUserEdit(){return "/admin/user/user-edit";}

    @RequestMapping("/toUserAdmin")
    public String toUserAdmin(){return "/admin/user/user-Administration";}

    @RequestMapping("/toUserInfoEdit")
    public String toUserInfoEdit(){return "/admin/user/user-info-edit";}

    @RequestMapping("/toChildrenAdd")
    public String toChildrenAdd(){return "/admin/user/children-add-edit";}

    @RequestMapping("/toGoodsList")
    public String toGoodsList(){return "/admin/goods/goods-list";}

    @RequestMapping("/toGoodsListAddEdit")
    public String toGoodsListAddEdit(){return "/admin/goods/good-add-edit";}

    @RequestMapping("/toGoodsListEdit")
    public String toGoodsListEdit(){return "/admin/goods/good-edit";}

    @RequestMapping("/toStaffList")
    public String toStaffList(){return "/admin/user/user-staff-list";}

    @RequestMapping("/toStaffAddList")
    public String toStaffAddList(){return "/admin/user/staff-add-edit";}

    @RequestMapping("/toStaffEditList")
    public String toStaffEditList(){return "/admin/user/staff-edit";}

    @RequestMapping("/reservationList")
    public String reservationList(){
        return "/admin/reservation/reservation-list";
    }

    @RequestMapping("/reservationList1")
    public String reservationList1(){
        return "/admin/reservation/reservation-jy";
    }

    @RequestMapping("/reservationEdit")
    public String reservationEdit(){return "/admin/reservation/reservation-edit";}

    @RequestMapping("/toOrderList")
    public String toOrderList(){return "/admin/order/order-list";}

    @RequestMapping("/toInformationList")
    public String toInformation(){return "/admin/information/information-list";}

    @RequestMapping("/toInformationEdit")
    public String toInformationEdit(){return "/admin/information/information-edit";}

    @RequestMapping("/toInformationAdd")
    public String toInformationAdd(){return "/admin/information/information-add";}


    @RequestMapping("/toPropose")
    public String toPropose(){
        return "/admin/about/proposal";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public ResultUtil updataPassword(UserVo userVo, HttpSession session){
        User user = userService.lambdaQuery().eq(User::getId, userVo.getId()).one();
        user.setPassword(userVo.getPassword());
        boolean b = userService.upDataPassword(user);
        session.removeAttribute("userId");
        if (b){
            return success("修改成功");
        }
        return success("修改失败");

    }

}
