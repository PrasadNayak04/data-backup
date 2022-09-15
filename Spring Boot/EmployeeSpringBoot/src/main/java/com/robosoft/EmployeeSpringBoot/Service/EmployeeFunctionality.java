package com.robosoft.EmployeeSpringBoot.Service;

import com.robosoft.EmployeeSpringBoot.Modal.Employee;

import java.util.List;

public interface EmployeeFunctionality {
    List<Employee> obtainAll();
    Employee obtainById(int id);
    String deleteById(int id);
    String saveEmployee(Employee employee);
    String updateEmployeeById(int id, Employee employee);
}
