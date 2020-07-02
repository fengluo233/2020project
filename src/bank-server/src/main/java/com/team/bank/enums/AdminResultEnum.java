package com.team.bank.enums;

public enum AdminResultEnum {

    REGIST_SUCCESS(0,"管理员注册成功"),
    EMPTY_ADMINNAME(1,"管理员姓名不能为空"),
    EMPTY_ADMINPWD(2,"密码不能为空"),
    EMPTY_JOBNUM(3,"工号不能为空"),
    LOGIN_SUCCESS(4,"管理员登陆成功"),
    LOGIN_ERROR(5,"管理员用户名有误或密码错误"),
    Check_SUCCES(6,"成功查看用户信息"),
    Check_ERROR(7,"无该号码的账户信息"),
    LOST_RIGHT(8,"重新设置用户密码"),
    LOST_ERROR(9,"身份认证失败"),
    RESET_SUCCESS(10,"挂失成功"),
    RESET_ERROR(11,"新设置的密码不能为空"),
    USERCHECK_SUCCESS(12,"身份验证成功"),
    USERCHECK_ERROR(13,"账号密码不匹配"),
    EMPTY_USERPWD(14,"密码不能为空"),
    EMPTY_EMAIL(15,"邮箱不能为空"),
    EMPTY_MOBILE(16,"手机号码不能为空"),
    CHANGEUSERINFO_SUCCESS(17,"修改信息成功");



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
