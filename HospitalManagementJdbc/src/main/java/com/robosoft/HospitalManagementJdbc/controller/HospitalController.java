package com.robosoft.HospitalManagementJdbc.controller;

import com.robosoft.HospitalManagementJdbc.model.Department;
import com.robosoft.HospitalManagementJdbc.model.Doctor;
import com.robosoft.HospitalManagementJdbc.model.Ward;
import com.robosoft.HospitalManagementJdbc.service.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalServices hospitalServices;

    @PostMapping("/addDepartment")
    public void addDepartment(@RequestBody Department department){
        hospitalServices.addDepartment(department);
    }

    @PostMapping("/addDoctor")
    public void addDoctor(@RequestBody Doctor doctor){
        hospitalServices.addDoctorToDepartment(doctor);
    }

    @PostMapping("/addWard")
    public void addWard(@RequestBody Ward ward){
        hospitalServices.addWard(ward);
    }


}
