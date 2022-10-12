package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Doctor {

    private int doctorId;
    private String doctorName;
    private String departmentName;

    public Doctor(String doctorName, String departmentName) {
        this.doctorName = doctorName;
        this.departmentName = departmentName;
    }

}
