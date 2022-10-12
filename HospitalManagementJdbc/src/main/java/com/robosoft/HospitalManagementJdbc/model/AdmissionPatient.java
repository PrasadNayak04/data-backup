package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;

@Data
public class AdmissionPatient extends Patient{
    private int admissionDays;

    public AdmissionPatient() {
        super();
    }

    public AdmissionPatient(String patientName, int age, String gender, long phoneNo, int admissionDays) {
        super(patientName, age, gender, phoneNo);
        this.admissionDays = admissionDays;
    }

}
