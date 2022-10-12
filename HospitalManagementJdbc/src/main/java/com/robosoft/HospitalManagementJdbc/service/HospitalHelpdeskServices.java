package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.stereotype.Service;

@Service
public interface HospitalHelpdeskServices {

    public int registerOpdPatient(OpdPatient opdPatient);

    public int registerAdmissionPatient(AdmissionPatient admissionPatient);

    public String bookAppointment(Appointment appointment);

    public String admitPatient(Admission admission);

    public Doctor findDoctor(String doctorName, String departmentName);

    public Ward findWArd(String wardName, String departmentName);

}
