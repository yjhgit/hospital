package com.yayangchun.traditionalchinesemedicinemuseum.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@Mapper
public interface UserDao extends BaseMapper<User> {

    public List<UserListVo> findAll();


    public List<UserListVo> findAllByName(@Param("account") String account);

    public Integer disable(@Param("id") Integer id,@Param("status") String status);

    public  Integer UserListUpDataById(@Param("account") String account,@Param("poweid") Integer poweid,@Param("id") Integer id);

    public Integer UpdatePower(@Param("id")Integer id,@Param("power") Integer power);

    public Integer findById(@Param("id") Integer id);

    public Integer UpdatePassword(@Param("id")Integer id,@Param("password") String password);

    public String findUUid(@Param("id")Integer id);

}

