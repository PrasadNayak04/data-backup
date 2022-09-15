package com.robosoft.EmployeeDatabaseApplication.Controller;

import com.robosoft.EmployeeDatabaseApplication.Modal.Employee;
import com.robosoft.EmployeeDatabaseApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prasad/springboot/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/findEmployeeById{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return employeeService.findEmployeeById(id);
    }
    @PostMapping("/saveEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployeeById(@PathVariable int id, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployeeById(id, updatedEmployee);
    }


}
