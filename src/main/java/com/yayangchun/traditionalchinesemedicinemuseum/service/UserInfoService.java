package com.yayangchun.traditionalchinesemedicinemuseum.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoEditDto;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoSelectDto;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface UserInfoService extends IService<UserInfo> {

    public UserInfo findByUserid(UserInfoSelectDto dto);

    public Integer upUserInfo(UserInfo editDto);

    public Integer UserListUpDataById(Integer id,String username);


    public List<UserInfo> findAll();
    public List<UserInfo> findAllByUserName(String username);
    public List<UserInfo> findAllByPhone(String phone);
    public List<UserInfo> findAllByPhoneAndUsername(String phone,String username);

    public Integer UpdateUserInfoById(UserInfo userInfo);


}

