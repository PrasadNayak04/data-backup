package com.robosoft.HospitalManagementJdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int departmentId;
    private String departmentName;

    private String hospitalName;

    public Department(String departmentName, String hospitalName) {
        this.departmentName = departmentName;
        this.hospitalName = hospitalName;
    }

}
