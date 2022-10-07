package com.robosoft.HospitalManagement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MedicalFile {
    private int patientId;
    List<MedicalRecord> medicalRecords;

    public MedicalFile(int patientId) {
        this.patientId = patientId;
        this.medicalRecords = new ArrayList<MedicalRecord>();
    }
}
