package com.robosoft.HospitalManagementJdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class OpdMedicalRecord {

    private int recordId;
    private int patientId;
    private String departmentName;
    private String doctorName;
    private LocalDate dateVisited;

    public OpdMedicalRecord(int patientId, String departmentName, String doctorName, LocalDate dateVisited) {
        this.patientId = patientId;
        this.departmentName = departmentName;
        this.doctorName = doctorName;
        this.dateVisited = dateVisited;
    }

}
