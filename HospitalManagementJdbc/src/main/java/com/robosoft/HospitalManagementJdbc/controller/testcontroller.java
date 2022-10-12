package com.robosoft.HospitalManagementJdbc.controller;

import com.robosoft.HospitalManagementJdbc.model.Helpdesk;
import com.robosoft.HospitalManagementJdbc.model.Patient;
import com.robosoft.HospitalManagementJdbc.service.HelpdeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
    @Autowired
    HelpdeskService helpdeskService;

}
