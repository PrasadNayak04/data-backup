package com.robosoft.department_service.controller;

import com.robosoft.department_service.entity.Department;
import com.robosoft.department_service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department){
        log.info("inside add department");
        return departmentService.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside find department by id");
        return departmentService.getDepartmentById(departmentId);
    }

}
