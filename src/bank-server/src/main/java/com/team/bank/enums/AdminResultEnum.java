package com.team.bank.enums;

public enum AdminResultEnum {

    REGIST_SUCCESS(0,"管理员注册成功"),
    EMPTY_ADMINNAME(1,"管理员姓名不能为空"),
    EMPTY_ADMINPWD(2,"密码不能为空"),
    EMPTY_JOBNUM(3,"工号不能为空"),
    LOGIN_SUCCESS(4,"管理员登陆成功"),
    LOGIN_ERROR(5,"管理员用户名有误或密码错误");



    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;
    private String message;

    AdminResultEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
