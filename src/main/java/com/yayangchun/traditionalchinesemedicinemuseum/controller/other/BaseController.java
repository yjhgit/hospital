package com.yayangchun.traditionalchinesemedicinemuseum.controller.other;


import com.yayangchun.traditionalchinesemedicinemuseum.exception.ServerException;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.ResultUtil;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public class BaseController {

    public ResultUtil success(Object o){
        return ResultUtil.success(o);
    }
    public ServerException fail(String o){
        return fail(500,o);
    }
    public ServerException fail(Integer code,String o){
        return new ServerException(code,o);
    }
}
