package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.DepartmentMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Symptom;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.*;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface DepartmentService extends IService<Department> {

    public List<Department> findAll();

    public Page<Department> findAllData(DepartmentVo departmentVo);

    void addDepartment(Department department);

    public List<String> qeurySymptomAll(Integer departmentId);

    List<Department> queryDoctorDepartment();
}

