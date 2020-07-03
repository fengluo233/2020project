package com.team.bank.model;

public class ComAsset {
    private String money_management;
    private Double total_assets;
    private String loan;
    private String ID;

    public String getMoney_management() {
        return money_management;
    }

    public void setMoney_management(String money_management) {
        this.money_management = money_management;
    }

    public Double getTotal_assets() {
        return total_assets;
    }

    public void setTotal_assets(Double total_assets) {
        this.total_assets = total_assets;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
