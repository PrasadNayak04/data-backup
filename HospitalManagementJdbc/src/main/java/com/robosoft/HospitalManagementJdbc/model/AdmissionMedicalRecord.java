package com.robosoft.HospitalManagementJdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionMedicalRecord {

    private int admissionRecordId;
    private int patientId;
    private String departmentName;
    private String wardName;
    private LocalDate admittedDate;

}
