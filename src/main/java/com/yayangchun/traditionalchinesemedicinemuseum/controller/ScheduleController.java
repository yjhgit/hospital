package com.yayangchun.traditionalchinesemedicinemuseum.controller;

import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DepartmentService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 科室信息
 * @author chenzw
 * @date 2023-03-31
 */
@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/querySchedule")
    @ResponseBody
    @ApiOperation("查询排期数据-跳转排期页面")
    public List<Schedule> querySchedule(Integer userId){
        List<Schedule> list = scheduleService.queryScheduleById(userId);
        return list;
    }

}
