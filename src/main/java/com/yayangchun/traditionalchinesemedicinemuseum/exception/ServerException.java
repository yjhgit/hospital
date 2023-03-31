package com.yayangchun.traditionalchinesemedicinemuseum.exception;


import com.yayangchun.traditionalchinesemedicinemuseum.enity.enums.ErrorEnum;
import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/


public class ServerException extends RuntimeException{

    private Integer code;

    public ServerException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ServerException(ErrorEnum e) {
        super(e.getMsg());
        this.code = getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
