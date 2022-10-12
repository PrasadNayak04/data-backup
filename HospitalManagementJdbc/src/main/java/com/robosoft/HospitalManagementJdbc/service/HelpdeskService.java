package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelpdeskService implements HelpdeskServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DoctorService doctorService;

    private String query;

    @Override
    public int registerOpdPatient(OpdPatient opdPatient) {
        query = "insert into Patient (Patient_Name, Age, Gender, Phone_No, Patient_Type) values (?,?,?,?,?)";
        jdbcTemplate.update(query, opdPatient.getPatientName(), opdPatient.getAge(), opdPatient.getGender(), opdPatient.getPhoneNo(), "OPD");
        query = "select max(Patient_Id) from Patient";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public int registerAdmissionPatient(AdmissionPatient admissionPatient) {
        query = "insert into Patient (Patient_Name, Age, Gender, Phone_No, Patient_Type, Admission_Days) values (?,?,?,?,?,?)";
        jdbcTemplate.update(query, admissionPatient.getPatientName(), admissionPatient.getAge(), admissionPatient.getGender(), admissionPatient.getPhoneNo(), "Admission", admissionPatient.getAdmissionDays());
        query = "select max(Patient_Id) from Patient";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public String bookAppointment(Appointment appointment) {
        if(doctorService.isAvailable())
        query = "insert into Appointments(Patient_Id, Department_Name, Doctor_Name) values (?,?,?)";
        jdbcTemplate.update(query, appointment.getPatientId(), appointment.getDepartmentName(), appointment.getDoctorName());
        return "Appointment booking successful";
    }

    @Override
    public String admitPatient(Admission admission) {
        query = "insert into Admissions (Patient_Id, Ward_Name, Department_Name) values (?,?,?)";
        jdbcTemplate.update(query, admission.getPatientId(), admission.getWardName(), admission.getDepartmentName());
        return "Admission successful";
    }

    public Doctor findDoctor(String doctorName, String departmentName){
        query = "select * from Doctor where Doctor_Name = '"+ doctorName + "' and Department_Name = '" + departmentName + "'";
        return jdbcTemplate.queryForObject(query, Doctor.class);
    }


}
