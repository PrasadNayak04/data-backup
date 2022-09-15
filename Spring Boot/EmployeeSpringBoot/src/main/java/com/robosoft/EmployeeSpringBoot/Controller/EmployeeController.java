package com.robosoft.EmployeeSpringBoot.Controller;

import com.robosoft.EmployeeSpringBoot.Modal.Employee;
import com.robosoft.EmployeeSpringBoot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeObject;

    @GetMapping("/")
    public String Hello(){
        return "----------Spring Boot Employee Demo-----------<br>" +
                "Visit <a href=\"http://localhost:8080/obtainAll\"> to view all the employees<br>"+
                "Visit <a href=\"http://localhost:8080/obtainById1\"> to find employee by ID<br>" +
                "Visit <a href=\"http://localhost:8080/deleteById1\"> to delete employee by ID<br>" +
                "Visit <a href=\"http://localhost:8080/SaveEmployee\"> to add employee<br>" +
                "Visit <a href=\"http://localhost:8080//updateById1\"> to update employee<br>"
                ;
    }

    @GetMapping("/obtainAll")
    public List<Employee> obtainAll(){
        return employeeObject.obtainAll();
    }

    @GetMapping("/obtainById{id}")
    public Employee obtainById(@PathVariable int id){
        return employeeObject.obtainById(id);
    }

    @GetMapping("/deleteById{id}")
    public String deleteById(@PathVariable int id){
        return employeeObject.deleteById(id);
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeObject.saveEmployee(employee);
    }

    @PostMapping("/updateEmployeeById{id}")
    public String updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
        return employeeObject.updateEmployeeById(id,employee);
    }

}
