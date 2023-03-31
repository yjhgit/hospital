package com.yayangchun.traditionalchinesemedicinemuseum.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author chenzw
 * @date 2023-03-31
 */
@Data
@TableName("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 上级id
     */
    private Integer pid;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室描述
     */
    private String departmentDes;

    /**
     * 排序
     */
    private Integer departmentSort;


}
