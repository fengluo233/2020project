package com.team.bank.enums;

public enum ComResultEnum {

    SUCCESS(0,"成功"),
    ID_ERROR(1,"卡号错误"),
    PWD_ERROR(2,"密码错误"),
    USED_ERROR(3,"卡号已存在"),
    LOGIN_ERROR(4,"卡号不存在"),
    ID_MISS(5,"卡号为空"),
    PSDDWORD_ERROR(6,"密码为空");


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;
    private String message;

    ComResultEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
