package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.Appointment;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorServices {

    public List<Appointment> getAppointments(String Doctor_Name, String Department_Name);

    public String consultPatients(Doctor doctor);

}
