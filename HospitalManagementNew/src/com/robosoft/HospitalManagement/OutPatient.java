package com.robosoft.HospitalManagement;

import lombok.Data;

@Data
public class OutPatient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private long telephoneNumber;

    public OutPatient(String name, int age, String gender, long telephoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephoneNumber = telephoneNumber;
    }
}
