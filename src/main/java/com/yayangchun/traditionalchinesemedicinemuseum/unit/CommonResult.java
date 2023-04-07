package com.yayangchun.traditionalchinesemedicinemuseum.unit;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: 统一返回
 **/
public class CommonResult {

    public static JSONObject fail(String err) {
        JSONObject object = new JSONObject();
        object.put("status", "FAIL");
        object.put("msg", err);
        object.put("code", 1);
        return object;
    }

    public static JSONObject success() {
        JSONObject object = new JSONObject();
        object.put("status", "SUCCESS");
        object.put("code", 0);
        return object;
    }

    public static JSONObject success(Object data) {
        JSONObject object = new JSONObject();
        object.put("status", "SUCCESS");
        object.put("data", data);
        object.put("code", 0);
        return object;
    }

    public static JSONObject success(Object data , String msg) {
        JSONObject object = new JSONObject();
        object.put("status", "SUCCESS");
        object.put("data", data);
        object.put("msg", msg);
        object.put("code", 0);
        return object;
    }

    public static JSONObject successPage(Object data, Long total) {
        JSONObject object = new JSONObject();
        object.put("status", "SUCCESS");
        object.put("data", data);
        object.put("count", total);
        object.put("code", 0);
        return object;
    }
}
