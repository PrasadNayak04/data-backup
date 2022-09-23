package com.robosoft.Insurance.Modal;

public class Car {
    private String regNo;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String regNo, String model, int year) {
        this.regNo = regNo;
        this.model = model;
        this.year = year;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
