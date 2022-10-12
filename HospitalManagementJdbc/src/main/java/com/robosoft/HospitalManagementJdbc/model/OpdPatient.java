package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;

public class OpdPatient extends Patient {

    public OpdPatient() {
        super();
    }

    public OpdPatient(String patientName, int age, String gender, long phoneNo) {
        super(patientName, age, gender, phoneNo);
    }

}
