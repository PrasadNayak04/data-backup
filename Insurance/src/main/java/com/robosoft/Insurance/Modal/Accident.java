package com.robosoft.Insurance.Modal;

import java.util.Date;

public class Accident {
    private int report_number;
    private Date acc_date;
    private String location;

    public Accident(int report_number, Date acc_date, String location) {
        this.report_number = report_number;
        this.acc_date = acc_date;
        this.location = location;
    }

    public int getReport_number() {
        return report_number;
    }

    public void setReport_number(int report_number) {
        this.report_number = report_number;
    }

    public Date getAcc_date() {
        return acc_date;
    }

    public void setAcc_date(Date date) {

        this.acc_date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
