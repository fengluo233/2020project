package com.team.bank.model;

public class LqAsset {
    private int ID;
    private String mobile;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMoney_management() {
        return money_management;
    }

    public void setMoney_management(double money_management) {
        this.money_management = money_management;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getAll(){
        return balance + money_management + funds + gold;
    }

    private double balance;
    private double money_management;
    private double funds;
    private double gold;
}
