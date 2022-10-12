package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelpdeskService implements HelpdeskServices, HospitalHelpdeskServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HospitalHelpdeskServices hospitalHelpdeskServices;

    @Autowired
    private HospitalServices hospitalServices;

    private String query;

    @Override
    public int registerOpdPatient(OpdPatient opdPatient) {
       return hospitalHelpdeskServices.registerOpdPatient(opdPatient);
    }

    @Override
    public int registerAdmissionPatient(AdmissionPatient admissionPatient) {
       return hospitalHelpdeskServices.registerAdmissionPatient(admissionPatient);
    }

    @Override
    public String bookAppointment(Appointment appointment) {
        Doctor doctor = findDoctor(appointment.getDoctorName(), appointment.getDepartmentName());
        if(hospitalServices.isAvailable(doctor)) {
            return hospitalHelpdeskServices.bookAppointment(appointment);
        }
        return "Doctor is not available. Please enter some other doctor name";
    }

    @Override
    public String admitPatient(Admission admission) {
        Ward ward = findWArd(admission.getWardName(), admission.getDepartmentName());
        if (hospitalServices.isVacant(ward)){
            return hospitalHelpdeskServices.admitPatient(admission);
        }
        return "Ward is full. Admit to some other ward of " + admission.getDepartmentName();
    }

    @Override
    public Doctor findDoctor(String doctorName, String departmentName){
        return hospitalHelpdeskServices.findDoctor(doctorName, departmentName);
    }

    @Override
    public Ward findWArd(String wardName, String departmentName) {
        return hospitalHelpdeskServices.findWArd(wardName, departmentName);
    }


}
