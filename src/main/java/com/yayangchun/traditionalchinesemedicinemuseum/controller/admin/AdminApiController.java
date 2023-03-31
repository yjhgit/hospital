package com.yayangchun.traditionalchinesemedicinemuseum.controller.admin;

import com.yayangchun.traditionalchinesemedicinemuseum.controller.other.BaseController;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.*;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.UserListVo;
import com.yayangchun.traditionalchinesemedicinemuseum.service.*;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 作者：崖洋春
 * 时间：2023/3/18 22:24
 **/
@RestController
@RequestMapping("/adminApi")
public class AdminApiController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ProposeService proposeService;

    @Autowired
    private DrugsService drugsService;

    @Autowired
    private ReservationDotService reservationDotService;

    @Autowired
    private ReservationYcService reservationYcService;

    //用户列表
    @RequestMapping("/UserList")
    public Map<String,Object> userList(String account){
        List<UserListVo> all;
        if (account!=null){
            all = userService.findAllByName(account);
        }else {
            all = userService.findAll();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    //禁用用户
    @RequestMapping("/disable")
    public ResultUtil disable(Integer id, String status){
        Integer disable;
        if (status.equals("1")){
            disable = userService.disable(id,"0");
            if (disable!=1){
                throw fail(500,"启用失败");
            }
            return ResultUtil.success("启用成功");
        }else {
            disable = userService.disable(id,"1");
            if (disable!=1){
                throw fail(500,"禁用失败");
            }
            return ResultUtil.success("禁用成功");
        }
    }

    //用户列表修改
    @RequestMapping("/UserEditByList")
    public ResultUtil UserEditByList(String username,String account,Integer power,Integer id){
        Integer integer = userService.UserListUpDataById(account, power, id);
        Integer integer1 = userInfoService.UserListUpDataById(id, username);
        if (integer!=1&&integer1!=1){
            throw fail(500,"修改失败");
        }
        return ResultUtil.success("修改成功");
    }

    //用户详情列表查询
    @RequestMapping("/UserInfoList")
    public Map<String,Object> UserInfoList(String username,String phone){

        List<UserInfo> all = new ArrayList<>();
        if ( username!=null && phone!=null ){//|| !username.equals("") && !phone.equals("")
            if (!username.equals("") && !phone.equals("")){
                all = userInfoService.findAllByPhoneAndUsername(username, phone);
            }else if (!username.equals("")){
                all = userInfoService.findAllByUserName(username);
            }else if (!phone.equals("")){
                all = userInfoService.findAllByPhone(phone);
            }else {
                all = userInfoService.findAll();
            }
        }else {
            all = userInfoService.findAll();
        }

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    @RequestMapping("/UserInfoEditByList")
    public ResultUtil UserInfoEditByList(UserInfo userInfo){
       Integer integer = userInfoService.UpdateUserInfoById(userInfo);
        if (integer==0){
            throw fail(500,"更新失败");
        }
        return ResultUtil.success("修改成功");
    }


    /**
     * 信息列表
     * @param title
     * @return
     */
    @RequestMapping("/informationList")
    public Map<String,Object> informationList(String title){
        List<Article> all;
        if (title!=null){
            if (title.equals("")){
                all = articleService.findAll();
            }else {
                all = articleService.findByTitle(title);
            }
        }else {
            all = articleService.findAll();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    /**
     * 添加信息
     * @param information
     * @return
     */
    @RequestMapping("/addInformation")
    public ResultUtil addInformation(Article information){
        information.setAddTime(new Date());
//        information.setUpdateTime(new Date());
        Integer integer = articleService.addInformation(information);
        if (integer==0){
            throw fail(500,"添加失败");
        }

        return ResultUtil.success("添加成功");
    }

    /**
     * 批量删除信息
     * @param id
     * @return
     */
    @RequestMapping("/delAllInformation")
    public ResultUtil delAllInformation(String id){
        Integer integer = articleService.delAllInFor(id);
        if (integer==0){
            throw fail(500,"删除失败");
        }
        return ResultUtil.success("删除成功");
    }

    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping("/delInformation")
    public ResultUtil delInformation(String id){
        boolean b = articleService.delById(id);
        if (!b){
            throw fail(500,"删除失败");
        }
        return ResultUtil.success("删除成功");
    }

    /**
     * 修改信息
     * @param information
     * @return
     */
    @RequestMapping("/updateByInformation")
    public ResultUtil updateByInformation(Article information){
        Integer integer = articleService.updateInformationById(information);
        if (integer==0){
            throw fail(500,"更新失败");
        }
        return ResultUtil.success("更新成功");
    }


    /**
     * 查询建议
     * @param name
     * @return
     */
    @RequestMapping("/seleByPropose")
    public Map<String,Object> seleByPropose(String name){
        List<Propose> all;
        if (name==null){
            all = proposeService.findByAdmin();
        }else {
            if ("".equals(name)){
                all = proposeService.findAll();
            }else {
               all =  proposeService.findByName(name);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    /**
     * 药材列表
     * @param name
     * @return
     */
    @RequestMapping("/drugsList")
    public Map<String,Object> drugsList(String name){
        List<Drugs> all;
        if (name==null){
            all = drugsService.findAll();
        }else {
            if ("".equals(name)){
                all = drugsService.findAll();
            }else {
                all =  drugsService.findByName(name);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }

    /**
     * 删除所有药材
     * @param id
     * @return
     */
    @RequestMapping("/delalldrugs")
    public ResultUtil delalldrugs(String id){
        Integer integer = drugsService.delAllById(id);
        if (integer==0){
            return ResultUtil.fail(500,"删除失败");
        }
        return ResultUtil.success("删除成功");
    }

    /**
     * 修改药材
     * @param drugs
     * @return
     */
    @RequestMapping("/updateByDrugs")
    public ResultUtil updateByDrugs(Drugs drugs){
        Integer integer = drugsService.updateByAdmin(drugs);
        if (integer==0){
            return ResultUtil.fail(500,"修改失败");
        }

        return ResultUtil.success("修改成功");
    }

    /**
     * 添加药材
     * @param drugs
     * @return
     */
    @RequestMapping("/addDrugs")
    public ResultUtil addDrugs(Drugs drugs){
        Integer integer = drugsService.addByAdmin(drugs);
        if (integer==0){
            return ResultUtil.fail(500,"添加失败");
        }
        return ResultUtil.success("添加成功");
    }

    /**
     * 查看医生的预约
     * @param name
     * @return
     */
    @RequestMapping("/findDot")
    public Map<String,Object> findDot(String name){
        List<ReservationDot> all;
        if (name==null){
            all = reservationDotService.findAllByAdmin();
        }else {
            if ("".equals(name)){
                all = reservationDotService.findAllByAdmin();
            }else {
               all =  reservationDotService.findAllByAdmin(name);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }
    /**
     * 查看煎药的预约
     * @param name
     * @return
     */
    @RequestMapping("/findYc")
    public Map<String,Object> findYc(String name){
        List<ReservationYc> all;
        if (name==null){
            all = reservationYcService.findAllByAdmin();
        }else {
            if ("".equals(name)){
                all = reservationYcService.findAllByAdmin();
            }else {
                all =  reservationYcService.findAllByAdmin(name);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",all.size());
        map.put("data",all);
        return map;
    }
}
