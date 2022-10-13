package com.robosoft.HospitalManagementJdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ward {

    private String wardName;
    private String departmentName;
    private String doctorName;
    private int capacity;

}
