package com.robosoft.Insurance.Modal;

public class Participated {
    private String driver_id;
    private String regNo;
    private int report_number;
    private int damage_amount;

    public Participated(String driver_id, String regNo, int report_number, int damage_amount) {
        this.driver_id = driver_id;
        this.regNo = regNo;
        this.report_number = report_number;
        this.damage_amount = damage_amount;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getReport_number() {
        return report_number;
    }

    public void setReport_number(int report_number) {
        this.report_number = report_number;
    }

    public int getDamage_amount() {
        return damage_amount;
    }

    public void setDamage_amount(int damage_amount) {
        this.damage_amount = damage_amount;
    }

}
