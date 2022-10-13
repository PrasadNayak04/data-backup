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

    @Autowired
    private HelpdeskDoctorServices helpdeskDoctorServices;

    @GetMapping("/viewAppointments/{doctorName}/{departmentName}")
    public List<Appointment> viewAppointments(@PathVariable String departmentName, @PathVariable String doctorName)
    {
        return doctorServices.getAppointments(departmentName, doctorName);
    }

    @PutMapping("/consult")
    public String consultPatients(@RequestBody Doctor doctor){
        return doctorServices.consultPatients(doctor);
    }
    
}
