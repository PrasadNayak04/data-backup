package com.robosoft.EmployeeDatabaseApplication.Service;

import com.robosoft.EmployeeDatabaseApplication.Modal.Employee;

import java.util.List;

public interface EmployeeRepository {

    String saveEmployee(Employee employee);
    Employee findEmployeeById(int id);
    String deleteEmployeeById(int id);
    String updateEmployeeById(int id, Employee employee);
    List<Employee> getAllEmployees();

}
