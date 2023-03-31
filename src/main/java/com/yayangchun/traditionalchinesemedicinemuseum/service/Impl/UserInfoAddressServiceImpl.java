package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.UserInfoAddressDao;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfoAddress;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@Service
public class UserInfoAddressServiceImpl extends ServiceImpl<UserInfoAddressDao, UserInfoAddress> implements UserInfoAddressService {

    @Autowired
    UserInfoAddressDao userInfoAddressDao;


    @Override
    public Integer addInfo(UserInfoAddress userInfoAddress) {
        return userInfoAddressDao.insert(userInfoAddress);
    }

    @Override
    public Integer UpdateInfoById(UserInfoAddress userInfoAddress) {
        return userInfoAddressDao.updateById(userInfoAddress);
    }

    @Override
    public UserInfoAddress findById(Integer id) {
        return lambdaQuery()
                .eq(UserInfoAddress::getUserInfoId,id)
                .one();
    }
}
