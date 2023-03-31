package com.yayangchun.traditionalchinesemedicinemuseum.controller.doctor;

import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ReservationDotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
