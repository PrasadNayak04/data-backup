package com.robosoft.Insurance.Modal;

public class Person {
    private String driver_id;
    private String name;
    private String address;

    public Person() {
    }

    public Person(String driver_id, String name, String address) {
        this.driver_id = driver_id;
        this.name = name;
        this.address = address;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
