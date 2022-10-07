package com.robosoft.HospitalManagement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {
    private String departmentName;
    private List<Doctor> doctors;
    private List<Ward> wards;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.doctors = new ArrayList<Doctor>();
        this.wards = new ArrayList<Ward>();
    }

    public Doctor findDoctorByName(String name){
        for(Doctor doctor : doctors){
            if(doctor.getDoctorName().equalsIgnoreCase(name))
                return doctor;
        }
        return null;
    }

    public void acceptOpdPatient(Patient patient, Doctor doctor, MedicalFile medicalFile, Hospital hospital){
        System.out.println("\nDepartment confirmation message----- Received OPD patient");
        doctor.acceptPatient(patient, medicalFile, hospital);
    }

    public void acceptInPatient(Patient patient, MedicalFile medicalFile, int numberOfDays, Hospital hospital){
        System.out.println("\nDepartment confirmation message----- Received OPD patient");
        for(Ward ward : wards){
            if(ward.isAvailable()){
                ward.admitPatient(patient, medicalFile, numberOfDays, hospital);
            }
        }
    }

}
