package com.team.bank.enums;

import jdk.nashorn.internal.objects.annotations.Getter;


public enum ResultEnum {

    SUCCESS(0,"成功"),
    USR_ERROR(1,"用户名错误"),
    PWD_ERROR(2,"密码错误");

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
