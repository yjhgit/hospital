package com.yayangchun.traditionalchinesemedicinemuseum.controller.login;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.UserDao;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.User;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.UserInfoAddress;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginUserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.RegisteredVo;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.VerifyVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoAddressService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserInfoService;
import com.yayangchun.traditionalchinesemedicinemuseum.service.UserService;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.SecurityUnit;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.SigarUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hyperic.sigar.OperatingSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/
@Controller
@RequestMapping("/login")
@Api(tags = "登录控制器")
public class LoginApiController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserDao userDao;

    @Autowired
    UserInfoAddressService userInfoAddressService;

    @RequestMapping("/admin")
    public String toAdminLogin(){
        return "/admin/login";
    }

    @RequestMapping("/user")
    public String toUser(){
        return "/login/login";
    }

    @RequestMapping("/doctor")
    public String toUserLogin(){
        return "/doctor/page/login-3";
    }


    /**
     * 注册
     * @param registeredVo
     * @return
     */
    @RequestMapping("/registered")
    @ResponseBody
    @ApiOperation("用户注册")
    public ResultUtil registered(RegisteredVo registeredVo){
        Long byUsername = userService.findByUsername(registeredVo);
        if (byUsername!=0){
            throw  fail(500,"账户已存在");
        }
        String uuid = UUID.randomUUID().toString();
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String digestHex = md5.digestHex(registeredVo.getPassword() + uuid);
        User user = new User();
        user.setAccount(registeredVo.getAccount());
        user.setUuid(uuid);
        user.setPassword(digestHex);
        user.setPower(1);
        user.setRole("普通用户");
        user.setStatus("0");
        userService.save(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setUsername(registeredVo.getUsername());
        userInfo.setPhone(registeredVo.getPhone());
        boolean save = userInfoService.save(userInfo);
        if (!save){
            throw  fail(500,"插入错误");
        }
        return success("注册成功");
    }

    /**
     * 普通用户登录
     * @param vo
     * @param session
     * @return
     */
    @RequestMapping("/ByUser")
    @ResponseBody
    @ApiOperation("普通用户登录")
    public ResultUtil ByUser(LoginVo vo, HttpSession session){
        session.removeAttribute("userId");
        User user = userService.login(vo);
        if (user==null){
            throw fail(500,"账号或密码错误");
        }else if (user.getStatus().equals("1")){
            throw fail(500,"你被禁止登录");
        }
        session.setAttribute("userId",user.getId());
        if (user.getPower()==2){
            return success("医生登录");
        }
        if (user.getPower()==4){
            return success("医生登录");
        }
        return success("登录成功");
    }

    /**
     * 管理员登录
     * @param vo
     * @param session
     * @return
     */
    @RequestMapping("/byadmin")
    @ResponseBody
    @ApiOperation("管理员登录")
    public ResultUtil loginByAdmin(LoginVo vo,HttpSession session){
        User user = userService.loginAdmin(vo);
        session.setAttribute("userId",user.getId());
        return ResultUtil.success("登录成功");
    }

    /**
     * 登录退出
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    @ApiOperation("登录退出")
    public String loginOut(HttpSession session){
        LoginUserVo loginInfo = SecurityUnit.getLoginInfo();
        if (loginInfo == null){
            return "/login/do";
        }
        Integer poweid = loginInfo.getPower();
        session.removeAttribute("userId");
        if (poweid==1){
            return "/admin/login";
        }
        return "/login/login";
    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    @ApiOperation("用户信息")
    public ResultUtil userInfo(){
        LoginUserVo vo = SecurityUnit.getLoginInfo();
        if (vo==null){
            return ResultUtil.fail(500,"请求失败");
//            throw fail("失败");
        }
        return success(vo);
    }


    /**
     * 查询系统配置
     * @return
     * @throws UnknownHostException
     */
    @RequestMapping("/toConfigure")
    @ResponseBody
    @ApiOperation("查询系统配置")
    public Map<String,Object> toConfigure() throws UnknownHostException {
        Map<String,Object> map = new HashMap<>();
        SigarUtil.initSigar();
        Properties props = System.getProperties();
        OperatingSystem OS = OperatingSystem.getInstance();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map1 = System.getenv();
        String userName = map1.get("USERNAME");                 // 获取用户名
        String computerName = map1.get("COMPUTERNAME");         // 获取计算机名
        String userDomain = map1.get("USERDOMAIN");             // 获取计算机域名

        map.put("username",userName);                            //用户名
        map.put("computerName",computerName);                    //计算机名
        map.put("userDomain",userDomain);                         //计算机域名
        map.put("ip",ip);                                        //本地ip地址
        map.put("HostName",addr.getHostName());                  //本地主机名

        map.put("adminName",props.getProperty("user.name"));     //用户的账户名称
        map.put("home",props.getProperty("user.home"));          //用户的主目录
        map.put("dir",props.getProperty("user.dir"));            //用户的当前工作目录


        map.put("VendorName",OS.getVendorName());            //操作系统名称
        map.put("Version",OS.getVersion());                  //操作系统的版本号


        return map;
    }

    /**
     * 验证账号是否存在
     * @param verifyVo
     * @return
     */
    @RequestMapping("/verify")
    @ResponseBody
    @ApiOperation("验证账号是否存在")
    public ResultUtil verify(VerifyVo verifyVo){
        Long byUsername = userService.findByUsername(verifyVo);
        System.out.println(byUsername);
        if (byUsername!=0){
//            return ResultUtil.fail(500,"账户已存在");
           throw  fail(500,"账户已存在");
        }
       return success("可以使用");
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    @ApiOperation("修改密码")
    public ResultUtil updatePassword(Integer id,String password,HttpSession session){
        String uUid = userDao.findUUid(id);
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String digestHex = md5.digestHex(password + uUid);
        Integer integer = userDao.UpdatePassword(id, digestHex);
        if (integer==0){
            throw fail(500,"修改失败");
        }
        session.removeAttribute("userId");
        return ResultUtil.success("修改成功");
    }

    /**
     * 用户地址查询
     * @param id
     * @return
     */
    @RequestMapping("/userAddress")
    @ResponseBody
    @ApiOperation("用户地址查询")
    public Map<String,Object> userAddress(Integer id){
        UserInfoAddress byId = userInfoAddressService.findById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("data",byId);
        return map;
    }


}
