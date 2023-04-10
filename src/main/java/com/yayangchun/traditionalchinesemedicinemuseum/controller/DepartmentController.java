package com.yayangchun.traditionalchinesemedicinemuseum.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Schedule;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoSelectDto;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.DepartmentVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginUserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DepartmentService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ScheduleService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.CommonResult;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.SecurityUnit;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科室信息
 * @author chenzw
 * @date 2023-03-31
 */
@Controller
@RequestMapping(value = "/departments")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/findAll")
    @ApiOperation("查询科室数据-跳转预约页面")
    public String findAll(Model model){
        List<Department> departmentAll = departmentService.findAll();
        model.addAttribute("list",departmentAll);
        return "/reception/doc/booking/description";
    }

    @RequestMapping("/findAllAdmin")
    @ApiOperation("跳转科室管理页面")
    public String findAllAdmin(){
        return "/admin/department/department-list";
    }

    @RequestMapping("/toDepartmentAdd")
    @ApiOperation("跳转科室新增页面")
    public String toDepartmentAdd(){
        return "/admin/department/department-add";
    }

    @RequestMapping("/findAllData")
    @ApiOperation("查询科室数据")
    @ResponseBody
    public JSONObject findAllData(DepartmentVo departmentVo){
        Page<Department> allData = departmentService.findAllData(departmentVo);
        return CommonResult.successPage(allData.getRecords(),allData.getTotal());
    }

    @RequestMapping("/queryDoctorDepartment")
    @ApiOperation("查询医生科室数据")
    @ResponseBody
    public List<Department> queryDoctorDepartment(){
        return departmentService.queryDoctorDepartment();
    }

    @RequestMapping("/addDepartment")
    @ApiOperation("新增科室")
    @ResponseBody
    public JSONObject addDepartment(Department department){
        departmentService.addDepartment(department);
        return CommonResult.success();
    }

    @RequestMapping("/deleteDepartment")
    @ApiOperation("删除科室")
    @ResponseBody
    public JSONObject deleteDepartment(Integer id){
        departmentService.removeById(id);
        return CommonResult.success();
    }

    @RequestMapping("/querySymptom")
    @ApiOperation("查询症状")
    @ResponseBody
    public List<String> querySymptom(Integer departmentId){

        return departmentService.qeurySymptomAll(departmentId);
    }

    @RequestMapping("/querySchedule")
    @ApiOperation("查询排期数据-跳转排期页面")
    public String querySchedule(Integer userId,Integer departmentId,Model model){
        LoginUserVo vo = SecurityUnit.getLoginInfo();
        String name = vo.getUserInfo().getUsername();
        UserInfoSelectDto userInfoSelectDto = new UserInfoSelectDto();
        userInfoSelectDto.setUserId(userId);
        UserInfo byUserid = userInfoService.findByUserid(userInfoSelectDto);
        model.addAttribute("userId",userId);
        model.addAttribute("departmentId",departmentId);
        model.addAttribute("doctorName",byUserid.getUsername());
        model.addAttribute("doctorId",byUserid.getUserId());
        model.addAttribute("username",name);
        return "/reception/doc/booking/schedule";
    }

}
