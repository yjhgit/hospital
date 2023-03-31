package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfoAddress;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface UserInfoAddressService extends IService<UserInfoAddress> {

    public Integer addInfo(UserInfoAddress userInfoAddress);

    public Integer UpdateInfoById(UserInfoAddress userInfoAddress);

    public UserInfoAddress findById(Integer id);

}
