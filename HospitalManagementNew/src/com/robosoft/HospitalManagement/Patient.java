package com.robosoft.HospitalManagement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private long telephoneNumber;

    public Patient(String name, int age, String gender, long telephoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephoneNumber = telephoneNumber;
    }
}
