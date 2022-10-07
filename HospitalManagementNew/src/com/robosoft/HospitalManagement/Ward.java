package com.robosoft.HospitalManagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Ward implements DepartmentWardInterface {
    private String wardNumber;

    private Doctor doctor;
    private int capacity;
    List<Patient> patients;
    List<MedicalFile> patientMedicalFiles;
    private int currentPatients = 0;

    public Ward(String wardNumber, Doctor doctor, int capacity) {
        this.wardNumber = wardNumber;
        this.doctor = doctor;
        this.capacity = capacity;
        this.patients  = new ArrayList<Patient>();
        this.patientMedicalFiles = new ArrayList<MedicalFile>();
    }

    public boolean isAvailable(){
        return currentPatients < capacity;
    }

    @Override
    public void admitPatient(Patient patient, MedicalFile medicalFile, int numberOfDays, Hospital hospital){
        System.out.println("\nConfirmation from ward----- Patient admitted to the ward");
        currentPatients++;
        this.patients.add(patient);
        this.patientMedicalFiles.add(medicalFile);
        doctor.consultWardPatients(patient, medicalFile, hospital);
    }

}
