package com.yayangchun.traditionalchinesemedicinemuseum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Propose;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * (Propose)表数据库访问层
 *
 * @author 崖洋春
 * @since 2023-03-19 16:21:37
 */
@Mapper
public interface ProposeMapper extends BaseMapper<Propose> {



}

