package com.robosoft.HospitalManagementJdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private int doctorId;
    private String doctorName;
    private String departmentName;

    public Doctor(String doctorName, String departmentName) {
        this.doctorName = doctorName;
        this.departmentName = departmentName;
    }

}
