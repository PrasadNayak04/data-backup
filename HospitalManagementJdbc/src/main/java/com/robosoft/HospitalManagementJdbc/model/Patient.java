package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private long phoneNo;

    public Patient(String patientName, int age, String gender, long phoneNo) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }

}
