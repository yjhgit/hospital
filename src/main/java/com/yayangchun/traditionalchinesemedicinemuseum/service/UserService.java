package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.RegisteredVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.VerifyVo;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public interface UserService extends IService<User> {

    public List<User> login(User user);

    public User login(LoginVo loginVo);

    public User login(String username, String password);

    public Long findByUsername(VerifyVo user);

    public User findByUsername(LoginVo user);

    public Long findByUsername(RegisteredVo user);

    public User findByUsernameToUser(User user);

    public User findById(Integer id);

    User findByUsername(String username);

    Boolean checkUsername(String username);

    public boolean upDataPassword(User user);

    User loginAdmin(LoginVo vo);

    public Long findByCount();

    public List<UserListVo> findAllByName(String account);

    public List<UserListVo> findAll();

    public Integer disable(Integer id, String status);

    public Integer UserListUpDataById(String account,Integer power,Integer id);

    public List<User> findDoctor(String account,Integer power);
}

