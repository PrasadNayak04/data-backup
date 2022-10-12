package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admission {

    private int admissionId;
    private int patientId;
    private String wardName;
    private String departmentName;

    public Admission(int patientId, String wardName, String departmentName) {
        this.patientId = patientId;
        this.wardName = wardName;
        this.departmentName = departmentName;
    }

}
