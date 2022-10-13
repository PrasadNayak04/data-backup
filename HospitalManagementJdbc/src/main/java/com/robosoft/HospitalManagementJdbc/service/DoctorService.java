package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Appointment;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import com.robosoft.HospitalManagementJdbc.model.OpdMedicalRecord;
import com.robosoft.HospitalManagementJdbc.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService implements DoctorServices, HelpdeskDoctorServices{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HelpdeskServices helpdeskServices;

    @Autowired
    private HelpdeskDoctorServices helpdeskDoctorServices;

    private List<Appointment> appointments;

    String query;

    public List<Appointment> getAppointments(String doctorName, String departmentName){
        Doctor doctor = helpdeskServices.findDoctor(doctorName, departmentName);
        return helpdeskServices.getAppointments(doctor);
    }

    @Override
    public String consultPatients(Doctor doctor) {
        appointments = getAppointments(doctor.getDoctorName(), doctor.getDepartmentName());
        for(Appointment appointment : appointments){
            consultPatient(appointment);
        }
        return "Done with consultation. Patient records sent to helpdesk. Please visit helpdesk to make the payments. Otherwise appointment won't be closed.";
    }

    public void consultPatient(Appointment appointment) {
        int amount = (int)(Math.random() * 500);
        generatePayment(new Payment(appointment.getAppointmentId(), amount));
    }

    @Override
    public void updateOpdMedicalRecord(OpdMedicalRecord opdMedicalRecord) {
        helpdeskDoctorServices.updateOpdMedicalRecord(opdMedicalRecord);
    }

    @Override
    public void closeAppointments(int appointmentId) {
        helpdeskDoctorServices.closeAppointments(appointmentId);
    }

    @Override
    public void generatePayment(Payment payment) {
        helpdeskDoctorServices.generatePayment(payment);
    }


}
