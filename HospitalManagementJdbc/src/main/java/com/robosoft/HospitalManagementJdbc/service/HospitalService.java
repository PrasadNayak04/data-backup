package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HospitalService implements HospitalServices, HospitalHelpdeskServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String query;
    @Override
    public String addDepartment(Department department) {
        query = "insert into department (Department_Name) values (?)";
        jdbcTemplate.update(query, department.getDepartmentName());
        return "New department added";
    }

    @Override
    public String addDoctorToDepartment(Doctor doctor) {
        query = "insert into Doctor (Doctor_Name, Department_Name) values (?,?)";
        jdbcTemplate.update(query, doctor.getDoctorName(), doctor.getDepartmentName());
        return "New doctor added";
    }

    @Override
    public String addWard(Ward ward) {
        query = "insert into Ward values (?,?,?,?)";
        jdbcTemplate.update(query, ward.getWardName(), ward.getDepartmentName(), ward.getDoctorId(), ward.getCapacity());
        return "New Ward added";
    }

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

    @Override
    public Doctor findDoctor(String doctorName, String departmentName) {
        query = "select * from Doctor where Doctor_Name = '"+ doctorName + "' and Department_Name = '" + departmentName + "'";
        return jdbcTemplate.queryForObject(query, Doctor.class);
    }

    @Override
    public Ward findWArd(String wardName, String departmentName) {
        query = "select * from Ward where Ward_Name = '"+ wardName + "' and Department_Name = '" + departmentName + "'";
        return jdbcTemplate.queryForObject(query, Ward.class);
    }

    @Override
    public boolean isAvailable(Doctor doctor) {
        query = "select count(Doctor_Id) from Appointments where Doctor_Id = '" + doctor.getDoctorId() + "' and Department_Name = '" + doctor.getDepartmentName() + "'";
        int count = jdbcTemplate.queryForObject(query, Integer.class);
        if(count > 3){
            return false;
        }
        return true;
    }

    @Override
    public boolean isVacant(Ward ward) {
        query = "select count(Ward_Name) from Admissions where Department_Name = '" + ward.getDepartmentName() + "'";
        int count = jdbcTemplate.queryForObject(query, Integer.class);
        if(count >= 10){
            return false;
        }
        return true;
    }


}
