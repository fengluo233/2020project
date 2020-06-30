package com.team.bank.enums;

import jdk.nashorn.internal.objects.annotations.Getter;


public enum ResultEnum {

    SUCCESS(0,"成功"),
    USR_ERROR(1,"用户名错误"),
    PWD_ERROR(2,"密码错误"),
    USED_ERROR(3,"用户已存在"),
    LOGIN_ERROR(4,"用户不存在"),
    USERNAME_MISS(5,"用户名为空"),
    PSDDWORD_ERROR(6,"密码为空");

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
