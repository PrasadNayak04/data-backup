package com.robosoft.HospitalManagement;

public interface HelpdeskDepartmentInterface {
    public void sendOpdPatientToDepartment(Patient patient, String departmentToVisit, String doctorToVisit);
    public void sendInPatientToDepartment(Patient patient, String departmentToVisit, int numberOfDays);
}
