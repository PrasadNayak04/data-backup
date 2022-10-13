package com.robosoft.HospitalManagementJdbc.controller;

import com.robosoft.HospitalManagementJdbc.model.*;
import com.robosoft.HospitalManagementJdbc.service.HelpdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpdesk")
public class HelpdeskController {

    @Autowired
    private HelpdeskService helpdeskService;

    @PostMapping("/opd")
    public int registerOpdPatient(@RequestBody OpdPatient opdPatient){
        return helpdeskService.registerOpdPatient(opdPatient);
    }

    @PostMapping("/admission")
    public int registerAdmissionPatient(@RequestBody AdmissionPatient admissionPatient){
        return helpdeskService.registerAdmissionPatient(admissionPatient);
    }

    @PostMapping("/appointment")
    public String bookAppointment(@RequestBody Appointment appointment){
        return helpdeskService.bookAppointment(appointment);
    }

    @PostMapping("/admit")
    public String admitPatient(@RequestBody Admission admission){
        return helpdeskService.admitPatient(admission);
    }

    @GetMapping("/opdRecords/{patientId}")
    public List<OpdMedicalRecord> getOpdRecords(@PathVariable int patientId){
        return helpdeskService.getOpdRecords(patientId);
    }

    @GetMapping("/admissionRecords/{patientId}")
    public List<AdmissionMedicalRecord> getAdmissionRecords(@PathVariable int patientId){
        return helpdeskService.getAdmissionRecords(patientId);
    }

    @GetMapping("/doctorAvailable/{doctorName}/{departmentName}")
    public boolean doctorAvailable(@PathVariable String doctorName, @PathVariable String departmentName){
        return helpdeskService.isAvailable(doctorName, departmentName);
    }

    @GetMapping("/availableDoctor/{departmentName}")
    public List<String> availableDoctorsInDepartment(@PathVariable String departmentName){
        return helpdeskService.viewAllAvailableDoctors(departmentName);
    }

    @GetMapping("/appointmentId/{patientId}")
    public int getAppointmentIdByPatientId(@PathVariable int patientId){
        return helpdeskService.getAppointmentIdByPatientId(patientId);
    }

    @GetMapping("/paymentAmount/{appointmentId}")
    public int getPaymentAmountByAppointmentId(@PathVariable int appointmentId){
        return helpdeskService.getPaymentByAppointmentId(appointmentId);
    }

    @DeleteMapping("/makePayment/{patientId}/{amount}")
    public String makePayment(@PathVariable int patientId, @PathVariable int amount){
        return helpdeskService.makePayment(patientId, amount);
    }


}
