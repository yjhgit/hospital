package com.yayangchun.traditionalchinesemedicinemuseum.enity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @date 2023-03-31
 */
@Data
public class DepartmentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科室名称
     */
    private String departmentName;

    // 页数
    private Integer page = 1;

    // 每页显示条数*
    private Integer limit = 10;

}
