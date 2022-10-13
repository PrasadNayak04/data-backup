package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospitalHelpdeskServices {

    public int registerOpdPatient(OpdPatient opdPatient);

    public int registerAdmissionPatient(AdmissionPatient admissionPatient);

    public String bookAppointment(Appointment appointment);

    public String admitPatient(Admission admission);

    public Doctor findDoctor(String doctorName, String departmentName);

    public Ward findWArd(String wardName, String departmentName);

    public List<Appointment> getAppointments(Doctor doctor);

    public void updateOpdMedicalRecord(OpdMedicalRecord opdMedicalRecord);

    public void closeAppointments(int appointmentId);

    public List<OpdMedicalRecord> getOpdRecords(int patientId);

    public List<AdmissionMedicalRecord> getAdmissionRecords(int patientId);

    public List<String> viewAllAvailableDoctors(String departmentName);

    public void generatePayment(Payment payment);

    public String makePayment(int patientId, int Amount);

    public int getAppointmentIdByPatientId(int patientId);
    public int getPaymentByAppointmentId(int appointmentId);

}
