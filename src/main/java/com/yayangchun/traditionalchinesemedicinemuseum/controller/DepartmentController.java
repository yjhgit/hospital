package com.yayangchun.traditionalchinesemedicinemuseum.controller;

import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Department> departmentAll = departmentService.findAll();
        model.addAttribute("list",departmentAll);
        return "/reception/doc/booking/description";
    }

}
