package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.DepartmentMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Symptom;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.DepartmentVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DepartmentService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> findAll() {
        // 查询科室数据
        List<Department> departmentAll = list();
        List<Department> departmentList = new ArrayList<>();
        // 数据固定两层 直接处理
        departmentAll.forEach(dep->{
            if(StringUtils.isEmpty(dep.getPid())){
                departmentList.add(dep);
            }
        });
        departmentList.forEach(dep->{
            departmentAll.forEach(depAll->{
                if(StringUtils.isNotEmpty(depAll.getPid()) && dep.getId().equals(depAll.getPid())){
                    if(StringUtils.isEmpty(dep.getSonList())){
                        dep.setSonList(new ArrayList<>());
                    }
                    dep.getSonList().add(depAll);
                }
            });
        });
        return departmentList;
    }

    @Override
    public Page<Department> findAllData(DepartmentVo departmentVo) {
        // 查询科室数据
        LambdaQueryWrapper<Department> lq = Wrappers.lambdaQuery();
        if(StringUtils.isNotEmpty(departmentVo.getDepartmentName())){
            lq = lq.eq(Department::getDepartmentName, departmentVo.getDepartmentName());
        }
        Page<Department> departmentPage = departmentMapper.selectPage(new Page<>(departmentVo.getPage(), departmentVo.getLimit()),lq);
        return departmentPage;
    }

    @Override
    public void addDepartment(Department department) {
        if(StringUtils.isNotEmpty(department) && StringUtils.isNotEmpty(department.getId())){
            departmentMapper.updateById(department);
        }else {
            departmentMapper.insert(department);
        }
    }

    @Override
    public List<String> qeurySymptomAll(Integer departmentId) {
        return departmentMapper.querySymptomAll(departmentId);
    }

    @Override
    public List<Department> queryDoctorDepartment() {
        // 查询科室数据
        List<Department> departmentAll = findAll();
        List<Department> departmentList = new ArrayList<>();
        departmentAll.forEach(dep->{
            if(StringUtils.isEmpty(dep.getSonList())){
                departmentList.add(dep);
            }else {
                dep.getSonList().forEach(son->{
                    departmentList.add(son);
                });
            }
        });
        return departmentList;
    }
}

