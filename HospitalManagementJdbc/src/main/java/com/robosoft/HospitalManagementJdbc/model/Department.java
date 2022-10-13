package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

    private int departmentId;
    private String departmentName;

    private String hospitalName;

    public Department(String departmentName, String hospitalName) {
        this.departmentName = departmentName;
        this.hospitalName = hospitalName;
    }

}
