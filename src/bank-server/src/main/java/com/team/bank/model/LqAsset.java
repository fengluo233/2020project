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

    public double getMoneyManagement() {
        return moneyManagement;
    }

    public void setMoneyManagement(double moneyManagement) {
        this.moneyManagement = moneyManagement;
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
        return balance + moneyManagement + funds + gold;
    }

    private double balance;
    private double moneyManagement;
    private double funds;
    private double gold;
}
