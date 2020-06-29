package com.team.bank.model;
/**
 * @title: Administrator
 * @package com.team.bank.model
 * @description: 银行管理员实体类，初始化了getter和setter方法，对应的数据库表是lq_administrator
 * @author: rushman
 * @date: 2020/6/29 15:38
 */
public class Administrator {
    private int adminId;
    private String adminName;
    private String adminPwd;
    private String jobNum;

    public int getAdminId() { return adminId; }

    public void setAdminId(int adminId){ this.adminId = adminId; }

    public String getAdminName(){ return adminName; }

    public void setAdminName(String adminName){ this.adminName = adminName; }

    public  String getAdminPwd(){ return adminPwd; }

    public void setAdminPwd(String adminPwd){ this.adminPwd = adminPwd; }

    public String getJobNum(){ return jobNum; }

    public void setJobNum(String jobNum){ this.jobNum = jobNum; }
}
