package com.robosoft.Insurance.Modal;

public class Owns {
    private String driver_id;
    private String regNo;

    public Owns(String driver_id, String regNo) {
        this.driver_id = driver_id;
        this.regNo = regNo;
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

}
