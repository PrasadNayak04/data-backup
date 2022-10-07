package com.robosoft.HospitalManagement;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Hospital implements HelpdeskDepartmentInterface {
    private String hospitalName;
    private Helpdesk helpdesk;
    public List<Department> departments;
    private HashMap<Integer, Patient> patients;
    private HashMap<Integer, MedicalFile> medicalFiles;
    int patientId = 0;

    public Hospital (String hospitalName){
        this.hospitalName = hospitalName;
        this.helpdesk = new Helpdesk(this);
        this.departments = new ArrayList<Department>();
        this.patients = new HashMap<Integer, Patient>();
        this.medicalFiles = new HashMap<Integer, MedicalFile>();
    }

    public void addPatient(Patient patient){
        patientId++;
        patient.setPatientId(patientId);
        this.patients.put(patientId, patient);
    }

    public void addDepartment(Department department){
        this.departments.add(department);
    }

    public void addWardToDepartment(Ward ward, Department department){
        department.getWards().add(ward);
    }

    public Department findDepartmentByName(String name){
        for(Department department : departments){
            if(department.getDepartmentName().equalsIgnoreCase(name))
                return department;
        }
        return null;
    }

    public void addDoctorToDepartment(Doctor doctor, Department department){
        department.getDoctors().add(doctor);
    }

    public MedicalFile createNewMedicalFile(int patientId){
        return new MedicalFile(patientId);
    }

    @Override
    public void sendOpdPatientToDepartment(Patient patient, String departmentToVisit, String doctorToVisit){

        Department department = findDepartmentByName(departmentToVisit);
        Doctor doctor = department.findDoctorByName(doctorToVisit);

        if(doctor.isAvailable()) {
            if (!(patients.containsValue(patient))) {
                addPatient(patient);
                department.acceptOpdPatient(patient, doctor, createNewMedicalFile(patient.getPatientId()),this);
            } else {
                MedicalFile medicalFile = getMedicalFiles().get(patient.getPatientId());
                department.acceptOpdPatient(patient, doctor, medicalFile, this);
            }
        }
    }

    @Override
    public void sendInPatientToDepartment(Patient patient, String departmentToVisit, int numberOfDays){
        addPatient(patient);
        Department department = findDepartmentByName(departmentToVisit);
        department.acceptInPatient(patient, createNewMedicalFile(patient.getPatientId()), numberOfDays, this);
    }

    public void updateMedicalFile(Patient patient, MedicalFile medicalFile){
        medicalFiles.put(patient.getPatientId(), medicalFile);
    }

}
