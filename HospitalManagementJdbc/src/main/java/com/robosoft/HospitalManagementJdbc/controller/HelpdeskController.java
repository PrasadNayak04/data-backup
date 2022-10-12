package com.robosoft.HospitalManagementJdbc.controller;

import com.robosoft.HospitalManagementJdbc.model.AdmissionPatient;
import com.robosoft.HospitalManagementJdbc.model.OpdPatient;
import com.robosoft.HospitalManagementJdbc.service.HelpdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
