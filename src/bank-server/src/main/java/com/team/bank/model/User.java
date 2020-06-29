package com.team.bank.model;
/**
 * @title: User
 * @package com.team.bank.model
 * @description: model层主要是一些实体类，做到和数据库表的一一对应。一般情况下一张数据库表对应一个实体类，然后初始化getter setter方法
 * 有必要的话还要添加toString方法
 * @author: fengluo
 * @date: 2020/6/25 2:14
*/
public class User {
    private int id;
    private String usrName;
    private String usrPwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

}
