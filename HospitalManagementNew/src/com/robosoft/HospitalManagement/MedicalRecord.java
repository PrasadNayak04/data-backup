package com.robosoft.HospitalManagement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicalRecord {
    private String diseaseFound;
    private String doctorVisited;
}
