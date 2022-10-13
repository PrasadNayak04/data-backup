package com.robosoft.HospitalManagementJdbc.service;

import com.robosoft.HospitalManagementJdbc.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelpdeskServices {
    public Doctor findDoctor(String doctorName, String departmentName);

    public List<Appointment> getAppointments(Doctor doctor);
    public boolean isAvailable(String doctorName, String departmentName);

}
