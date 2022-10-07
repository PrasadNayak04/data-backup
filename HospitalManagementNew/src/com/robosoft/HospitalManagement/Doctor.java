package com.robosoft.HospitalManagement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Doctor implements DepartmentDoctorInterface{
    private String doctorName;
    private int maxPatientCount = 2;
    private int currentPatientCount = 0;
    List<Patient> patients;
    List<MedicalFile> patientMedicalFiles;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        this.patientMedicalFiles = new ArrayList<MedicalFile>();
        this.patients =  new ArrayList<Patient>();
    }

    public boolean isAvailable(){
        return currentPatientCount < maxPatientCount;
    }

    @Override
    public void acceptPatient(Patient patient, MedicalFile medicalFile, Hospital hospital){
        patientMedicalFiles.add(medicalFile);
        patients.add(patient);
        System.out.println("\nConfirmation from doctor----- Patient added to doctors List\n");
        currentPatientCount++;
        if(!(isAvailable()))
        {
            consultPatient(hospital);
        }
    }

    public void consultPatient(Hospital hospital){
        while(patients.size() > 0){
            System.out.println("\nConsulting patient " + patients.get(0).getName());
            createRecordAndUpdate(patients.get(0), patientMedicalFiles.get(0), hospital);
            patients.remove(0);
            patientMedicalFiles.remove(0);
        }
    }

    public void consultWardPatients(Patient patient, MedicalFile medicalFile, Hospital hospital){
        System.out.println("\nConsulting admitted ward patient " + patient.getName());
        MedicalRecord medicalRecord = new MedicalRecord("Dengue", doctorName);
        medicalFile.getMedicalRecords().add(medicalRecord);
        hospital.updateMedicalFile(patient, medicalFile);
    }

    public void createRecordAndUpdate(Patient patient, MedicalFile medicalFile, Hospital hospital){
        MedicalRecord medicalRecord = new MedicalRecord("Common Cold", doctorName);
        medicalFile.getMedicalRecords().add(medicalRecord);
        hospital.updateMedicalFile(patient, medicalFile);
    }

}
