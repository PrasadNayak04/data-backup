package com.robosoft.EmployeeSpringBoot.Service;

import com.robosoft.EmployeeSpringBoot.Modal.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService implements EmployeeFunctionality{

    List<Employee> employees = new ArrayList<Employee>();

    @Override
    public List<Employee> obtainAll() {
        return employees;
    }

    @Override
    public Employee obtainById(int id) {
        Employee employee = employees.stream().filter(e -> e.getId() == id).findAny().orElse(null);
        return employee;
    }

    @Override
    public String deleteById(int id) {
        Employee employee = obtainById(id);
        if( employee == null){
            return "Employee with id " + id + " does not exists";
        }
        employees.remove(employee);
        return "Employees deleted successfully";
    }

    @Override
    public String saveEmployee(Employee employee) {
        if(obtainById(employee.getId()) != null){
            return "Employee with id " + employee.getId() + " is already exists";
        }
        employees.add(employee);
        return "Employee added successfully.....";
    }

    @Override
    public String updateEmployeeById(int id, Employee employee) {
        Employee e = obtainById(id);

        if(e!= null) {
            if (employee.getName() != null)
                e.setName(employee.getName());

            if (employee.getDepartment() != null)
                e.setName(employee.getDepartment());

            if (employee.getLocation() != null)
                e.setName(employee.getDepartment());

            if (employee.getLocation() != null)
                e.setName(employee.getLocation());

            return "Employee details updated successfully.....";
        }
        return "Employee with id " + id + "not found...";
    }
}
