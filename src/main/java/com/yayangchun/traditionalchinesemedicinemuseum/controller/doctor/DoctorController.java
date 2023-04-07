package com.yayangchun.traditionalchinesemedicinemuseum.controller.doctor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：崖洋春
 * 时间：2023/3/9 17:29
 **/
@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/doctor/index";
    }


    @RequestMapping("/toWelcome3")
    public String toWelcome3(){ return "/doctor/page/welcome-3";}

    @RequestMapping("/chat")
    public String chat(){ return "/doctor/chat/newChat";}

    @RequestMapping("/toPasswordEdit")
    public String toPasswordEdit(){return "/doctor/info/password-edit";}

    @RequestMapping("/reservationList")
    public String reservationList(){
        return "/doctor/yy/reservation-list";
    }

    @RequestMapping("/toDoctorList")
    public String toDoctorList(){
        return "/admin/user/doctor-list";
    }

    @RequestMapping("/toDoctorSchedule")
    public String toDoctorSchedule(){
        return "/admin/user/schedule";
    }
}
