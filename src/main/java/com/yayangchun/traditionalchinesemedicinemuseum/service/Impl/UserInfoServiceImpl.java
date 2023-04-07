package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.UserInfoDao;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoEditDto;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoSelectDto;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {


    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public UserInfo findByUserid(UserInfoSelectDto dto) {
        return lambdaQuery()
                .eq(UserInfo::getUserId,dto.getUserId())
                .one();
    }

    @Override
    public List<UserInfo> findAll() {
        return lambdaQuery().list();
    }

    @Override
    public List<UserInfo> findAllByUserName(String username) {
        return lambdaQuery()
                .like(UserInfo::getUsername,username)
                .list();
    }

    @Override
    public List<UserInfo> findAllByPhone(String phone) {
        return lambdaQuery()
                .like(UserInfo::getPhone,phone)
                .list();
    }

    @Override
    public List<UserInfo> findAllByPhoneAndUsername(String phone, String username) {
        return lambdaQuery()
                .like(UserInfo::getUsername,username)
                .like(UserInfo::getPhone,phone)
                .list();
    }


    @Override
    public Integer upUserInfo(UserInfo editDto) {
        return updateById(editDto)?1:0;
    }

    @Override
    public Integer UserListUpDataById(Integer id, String username) {
        return userInfoDao.UserListUpDataById(id,username);
    }

    @Override
    public Integer UpdateUserInfoById(UserInfo userInfo) {
        return userInfoDao.updateById(userInfo);
    }

    @Override
    public List<UserInfo> queryUserInfoByDepId(Integer depId) {
        return userInfoDao.queryUserInfoByDepId(depId);
    }

    @Override
    public List<UserInfo> findAllByRole() {
        return userInfoDao.findAllByRole(3);
    }
}

