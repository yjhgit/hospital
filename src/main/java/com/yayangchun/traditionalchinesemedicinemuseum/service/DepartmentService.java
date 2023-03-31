package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.DepartmentMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.RegisteredVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.VerifyVo;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface DepartmentService extends IService<Department> {

    public List<Department> findAll();

}

