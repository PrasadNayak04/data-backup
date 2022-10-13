package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService implements HospitalServices, HospitalHelpdeskServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String query;
    @Override
    public String addDepartment(Department department) {
        query = "insert into department (Department_Name, Hospital_Name) values (?, ?)";
        jdbcTemplate.update(query, department.getDepartmentName(), department.getHospitalName());
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
        jdbcTemplate.update(query, ward.getWardName(), ward.getDepartmentName(), ward.getDoctorName(), ward.getCapacity());
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
        query = "insert into Appointments (Patient_Id, Department_Name, Doctor_Name) values (?,?,?)";
        jdbcTemplate.update(query, appointment.getPatientId(), appointment.getDepartmentName(), appointment.getDoctorName());
        return "Appointment booking successful";
    }

    @Override
    public String admitPatient(Admission admission) {
        query = "insert into Admissions (Patient_Id, Ward_Name, Department_Name) values (?,?,?)";
        jdbcTemplate.update(query, admission.getPatientId(), admission.getWardName(), admission.getDepartmentName());
        query = "insert into AdmissionsHistory (Patient_Id, Ward_Name, Department_Name) values (?,?,?)";
        jdbcTemplate.update(query, admission.getPatientId(), admission.getWardName(), admission.getDepartmentName());
        return "Admission successful";
    }

    @Override
    public Doctor findDoctor(String doctorName, String departmentName) {
        query = "select Doctor_Id, Doctor_Name, Department_Name from Doctor where Doctor_Name = '"+ doctorName + "' and Department_Name = '" + departmentName + "'";
        return jdbcTemplate.queryForObject(query, (resultSet, no)-> {Doctor doctor = new Doctor();
        doctor.setDoctorId(resultSet.getInt(1));
        doctor.setDoctorName(resultSet.getString(2));
        doctor.setDepartmentName(resultSet.getString(3));
        return doctor;
        });
    }

    @Override
    public Ward findWArd(String wardName, String departmentName) {
        query = "select * from Ward where Ward_Name = '"+ wardName + "' and Department_Name = '" + departmentName + "'";
        return jdbcTemplate.queryForObject(query, (resultSet, no)-> {Ward ward = new Ward();
            ward.setWardName(resultSet.getString(1));
            ward.setDepartmentName(resultSet.getString(2));
            ward.setDoctorName(resultSet.getString(3));
            ward.setCapacity(resultSet.getInt(4));
            return ward;
        });
    }

    @Override
    public List<Appointment> getAppointments(Doctor doctor) {
        query = "select * from appointments where Doctor_Name = '" + doctor.getDoctorName() + "' and Department_Name = '" + doctor.getDepartmentName() + "'";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<Appointment>(Appointment.class));
    }

    @Override
    public void updateOpdMedicalRecord(OpdMedicalRecord opdMedicalRecord) {
        query = "insert into OpdMedicalRecord (Patient_Id, Department_Name, Doctor_Name, Date_Visited) values(?,?,?,?)";
        jdbcTemplate.update(query, opdMedicalRecord.getPatientId(), opdMedicalRecord.getDepartmentName(), opdMedicalRecord.getDoctorName(), opdMedicalRecord.getDateVisited());
    }

    @Override
    public void closeAppointments(int appointmentId) {
        //retrieve appointment to put into appointment history
        query = "select * from Appointments where Appointment_Id = " + appointmentId;
        Appointment appointment = jdbcTemplate.queryForObject(query, (resultSet, no)-> { Appointment appointment1 = new Appointment();
            appointment1.setAppointmentId(resultSet.getInt(1));
            appointment1.setPatientId(resultSet.getInt(2));
            appointment1.setDepartmentName(resultSet.getString(3));
            appointment1.setDoctorName(resultSet.getString(4));
            return appointment1;
        });

        query = "delete from Appointments where Appointment_Id = ?";
        jdbcTemplate.update(query, appointmentId);

        query = "insert into AppointmentsHistory values(?,?,?,?)";
        jdbcTemplate.update(query, appointment.getAppointmentId(), appointment.getPatientId(), appointment.getDepartmentName(), appointment.getDoctorName());

        OpdMedicalRecord opdMedicalRecord = new OpdMedicalRecord(appointment.getPatientId(), appointment.getDepartmentName(), appointment.getDoctorName(), LocalDate.now());
        updateOpdMedicalRecord(opdMedicalRecord);

    }

    @Override
    public List<OpdMedicalRecord> getOpdRecords(int patientId) {
        query = "select * from OpdMedicalRecord where Patient_Id = " + patientId;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<OpdMedicalRecord>(OpdMedicalRecord.class));
    }

    @Override
    public List<AdmissionMedicalRecord> getAdmissionRecords(int patientId) {
        query = "select * from AdmissionMedicalRecord where Patient_Id = " + patientId;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<AdmissionMedicalRecord>(AdmissionMedicalRecord.class));
    }

    @Override
    public List<String> viewAllAvailableDoctors(String departmentName) {
        List<String> doctorNames = new ArrayList<String>();
        query = "select * from Doctor where Department_Name = '" + departmentName + "'";
        List<Doctor> doctors = jdbcTemplate.query(query, new BeanPropertyRowMapper<Doctor>(Doctor.class));
        for(Doctor doctor : doctors){
            if (isAvailable(doctor)){
                doctorNames.add(doctor.getDoctorName());
            }
        }
        return doctorNames;
    }

    @Override
    public void generatePayment(Payment payment) {
        query = "insert into PaymentPending (Appointment_Id, Amount) values (?,?)";
        jdbcTemplate.update(query, payment.getAppointmentId(), payment.getAmount());
    }

    @Override
    public String makePayment(int patientId, int amount) {
        int appointmentId = getAppointmentIdByPatientId(patientId);
        query = "select Amount from PaymentPending where Appointment_Id = " + appointmentId;
        int amountToBePaid = jdbcTemplate.queryForObject(query, Integer.class);
        if(amountToBePaid == amount){
            query = "delete from PaymentPending where Appointment_Id = " + appointmentId;
            jdbcTemplate.update(query);
            closeAppointments(appointmentId);
            return "Payment successful. Appointment closed.";
        }
        return "Invalid amount. Payment failed. Failed to close the appointment.";
    }

    @Override
    public int getPaymentByAppointmentId(int appointmentId) {
        query = "select Amount from PaymentPending where Appointment_Id = " + appointmentId;
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public boolean isAvailable(Doctor doctor) {
        query = "select count(Doctor_Name) from Appointments where Doctor_Name = '" + doctor.getDoctorName() + "' and Department_Name = '" + doctor.getDepartmentName() + "'";
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

    public int getAppointmentIdByPatientId(int patientId){
        query = "select max(Appointment_Id) from Appointments where Patient_Id = " + patientId;
        return jdbcTemplate.queryForObject(query, Integer.class);
    }



}
