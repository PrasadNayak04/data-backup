package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Admission;
import com.robosoft.HospitalManagementJdbc.model.AdmissionPatient;
import com.robosoft.HospitalManagementJdbc.model.Appointment;
import com.robosoft.HospitalManagementJdbc.model.OpdPatient;
import org.springframework.stereotype.Service;

public interface HelpdeskServices {

    public int registerOpdPatient(OpdPatient opdPatient);
    public int registerAdmissionPatient(AdmissionPatient admissionPatient);

    public String bookAppointment(Appointment appointment);

    public String admitPatient(Admission admission);
}
