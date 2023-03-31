package com.yayangchun.traditionalchinesemedicinemuseum.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

    public Integer UserListUpDataById(@Param("id") Integer userid, @Param("username") String username);


}

