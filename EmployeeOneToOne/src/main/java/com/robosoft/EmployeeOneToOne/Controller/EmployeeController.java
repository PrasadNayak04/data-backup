package com.robosoft.EmployeeOneToOne.Controller;

import com.robosoft.EmployeeOneToOne.Modal.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("onetoone/employee")
public class EmployeeController {

    @GetMapping("/save")
    public void save(@RequestBody Employee employee){

    }

}
