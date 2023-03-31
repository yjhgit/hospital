package com.yayangchun.traditionalchinesemedicinemuseum.enity.enums;


import com.yayangchun.traditionalchinesemedicinemuseum.exception.ServerException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    /**
     * 用户名密码错误
     */
    USERNAME_OR_PASSWORD(500, "用户名密码错误"),

    /**
     * 用户不存在
     */
    USER_EMPTY(500, "用户不存在"),
    ;

    private final Integer code;
    private final String msg;

    public ServerException toException() {
        return new ServerException(code, msg);
    }
}
