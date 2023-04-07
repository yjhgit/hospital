package com.yayangchun.traditionalchinesemedicinemuseum.controller.doctor;

import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ReservationDotService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：崖洋春
 * 时间：2023/3/9 17:29
 **/
@RestController
@RequestMapping("/docApi")
public class DoctorApiController {

    @Autowired
    private ReservationDotService reservationDotService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;
    /**
     * 查看医生的预约
     * @param name
     * @return
     */
    @RequestMapping("/findDot")
    public Map<String,Object> findDot(String name){
        List<ReservationDot> all;
        if (name==null){
            all = reservationDotService.findAllByAdmin();
        }else {
            if ("".equals(name)){
                all = reservationDotService.findAllByAdmin();
            }else {
                all =  reservationDotService.findAllByAdmin(name);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    /**
     * 根据科室id查询用户
     * @param depId
     * @return
     */
    @RequestMapping("/queryUserByDepId")
    @ResponseBody
    @ApiOperation("根据科室id查询用户")
    public List<UserInfo> queryUserByDepId(Integer depId){
        return userInfoService.queryUserInfoByDepId(depId);
    }

    // 医生专家列表
    @RequestMapping("/doctorList")
    public Map<String,Object> doctorList(String account,Integer power){
        List<User> doctor = userService.findDoctor(account, power);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",doctor.size());
        map.put("data",doctor);
        return map;
    }

    @ApiOperation("修改医生排期配置")
    @RequestMapping("/updateConfig")
    public Map<String,Object> updateConfig(User user){
        boolean b = userService.updateById(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",b);
        return map;
    }

}
