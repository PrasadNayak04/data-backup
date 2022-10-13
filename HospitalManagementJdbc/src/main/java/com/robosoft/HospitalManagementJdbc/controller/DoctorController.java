package com.robosoft.HospitalManagementJdbc.controller;

import com.robosoft.HospitalManagementJdbc.model.Appointment;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import com.robosoft.HospitalManagementJdbc.service.DoctorServices;
import com.robosoft.HospitalManagementJdbc.service.HelpdeskDoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @GetMapping("/viewAppointments/{doctorName}/{departmentName}")
    public List<Appointment> viewAppointments(@PathVariable String doctorName, @PathVariable String departmentName)
    {
        return doctorServices.getAppointments(doctorName, departmentName);
    }

    @PutMapping("/consult")
    public String consultPatients(@RequestBody Doctor doctor){
        return doctorServices.consultPatients(doctor);
    }
    
}
