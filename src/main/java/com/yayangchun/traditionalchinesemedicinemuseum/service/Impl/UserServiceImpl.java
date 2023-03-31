package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.UserDao;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.enums.ErrorEnum;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.RegisteredVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.VerifyVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> login(User user) {
        List<User> list = lambdaQuery()
                .eq(User::getAccount, user.getAccount())
                .eq(User::getPassword, user.getPassword())
                .list();
        return list;
    }

    @Override
    public User login(LoginVo loginVo) {
        String uuid = findByUsername(loginVo).getUuid();
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String digestHex = md5.digestHex(loginVo.getPassword() + uuid);
        loginVo.setPassword(digestHex);
        return login(loginVo.getAccount(),loginVo.getPassword());
    }

    public static void main(String[] args) {
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        String digestHex = md5.digestHex("123456" + uuid);
        System.out.println(digestHex);
    }

    @Override
    public User login(String username, String password) {
        return lambdaQuery()
                .eq(User::getAccount, username)
                .eq(User::getPassword, password).one();
    }

    @Override
    public Long findByUsername(VerifyVo user) {
        return lambdaQuery()
                .eq(User::getAccount, user.getAccount()).count();
    }

    @Override
    public User findByUsername(LoginVo user) {

        return lambdaQuery().eq(User::getAccount, user.getAccount()).one();

    }

    @Override
    public Long findByUsername(RegisteredVo user) {
        return lambdaQuery()
                .eq(User::getAccount, user.getAccount()).count();
    }

    @Override
    public User findByUsernameToUser(User user) {
        return lambdaQuery().eq(User::getAccount,user.getAccount()).one();
    }



    @Override
    public Boolean checkUsername(String username) {
        User user = findByUsername(username);
        return user != null;
    }

    @Override
    public User findByUsername(String username) {
        return lambdaQuery().eq(User::getAccount,username).one();
    }

    @Override
    public boolean upDataPassword(User user) {

        return updateById(user);
    }

    @Override
    public User loginAdmin(LoginVo vo) {

        if (!checkUsername(vo.getAccount())) {
//            System.out.println(!checkUsername(vo.getAccount())+"但是进来了");
            throw ErrorEnum.USER_EMPTY.toException();
        }
        User user = login(vo.getAccount(), vo.getPassword());
        if (user == null) {
            throw ErrorEnum.USERNAME_OR_PASSWORD.toException();
        }
        if (user.getPower() != 0){
            throw ErrorEnum.USER_EMPTY.toException();
        }
        return user;
    }

    @Override
    public Long findByCount() {
        return lambdaQuery().count();
    }

    @Override
    public List<UserListVo> findAllByName(String account) {
        return userDao.findAllByName(account);
    }

    @Override
    public List<UserListVo> findAll() {
        return userDao.findAll();
    }

    @Override
    public Integer disable(Integer id, String status) {
        return userDao.disable(id,status);
    }

    @Override
    public Integer UserListUpDataById(String account, Integer power, Integer id) {
        return userDao.UserListUpDataById(account,power,id);
    }


}

