package com.yayangchun.traditionalchinesemedicinemuseum.unit;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.dto.userinfo.UserInfoSelectDto;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginUserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public class SecurityUnit {

    public static LoginUserVo getLoginInfo(){

        UserInfoService infoService = SpringUtil.getBean(UserInfoService.class);
        UserService userService = SpringUtil.getBean(UserService.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("userId");
        if (id == null) {
            return null;
        }

        LoginUserVo vo = new LoginUserVo();
        User user = userService.getById(id);
        UserInfoSelectDto userInfoSelectDto = new UserInfoSelectDto();
        userInfoSelectDto.setUserId(user.getId());
        UserInfo byUserid = infoService.findByUserid(userInfoSelectDto);
        vo.setUserInfo(byUserid);
        BeanUtil.copyProperties(user,vo);

        return vo;
    }
}
