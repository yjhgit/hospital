package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.DepartmentMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return list();
    }
}

