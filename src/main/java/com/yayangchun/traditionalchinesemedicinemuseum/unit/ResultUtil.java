package com.yayangchun.traditionalchinesemedicinemuseum.unit;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

public class ResultUtil {
    private Integer code;
    private Object data;

    public ResultUtil() {
    }

    public ResultUtil(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultUtil success(Object data){
        return new ResultUtil(200, data);
    }

    public static ResultUtil fail(Object data){
        return new ResultUtil(500, data);
    }

    public static ResultUtil fail(Integer code,Object data){
        return new ResultUtil(code, data);
    }
}
