package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.OpdMedicalRecord;
import com.robosoft.HospitalManagementJdbc.model.Payment;
import org.springframework.stereotype.Service;

@Service
public interface HelpdeskDoctorServices {

    public void updateOpdMedicalRecord(OpdMedicalRecord opdMedicalRecord);

    public void closeAppointments(int appointmentId);

    public void generatePayment(Payment payment);

}
