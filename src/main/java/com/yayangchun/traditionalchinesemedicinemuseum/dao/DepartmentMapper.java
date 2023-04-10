package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (ReservationDot)表数据库访问层
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * @description: 查询症状
     * @date 2023/4/7
     */
    @Select("select name from symptom where department_id = #{departmentId}")
    List<String> querySymptomAll(@Param("departmentId") Integer departmentId);
}

