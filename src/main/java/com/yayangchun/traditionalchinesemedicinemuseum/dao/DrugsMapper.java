package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * (Drugs)表数据库访问层
 *
 * @author 崖洋春
 * @since 2023-03-19 20:02:46
 */
@Mapper
public interface DrugsMapper extends BaseMapper<Drugs> {

    public Integer delAllById(String id);

}

