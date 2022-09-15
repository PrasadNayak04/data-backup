package com.robosoft.EmployeeDatabaseApplication.Service;

import com.robosoft.EmployeeDatabaseApplication.Modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String saveEmployee(Employee employee) {
        String query = "insert into Employee values(?,?,?,?)";
        int status = jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getDepartment(),employee.getLocation());
        if(status == 1){
            return "Employee added successfully";
        }
        return "Failed to add the employee";
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee;
        String query = "select * from Employee where Id = " + id;
        try{
            employee = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Employee>(Employee.class));
        }catch(DataAccessException dataAccessException){
            employee = null;
        }
        return employee;
    }

    @Override
    public String deleteEmployeeById(int id) {
        String query = "delete from Employee where id = ?";
        int status = jdbcTemplate.update(query,id);
        if(status == 1){
            return "Employee deleted successfully";
        }
        return "Failed to delete the employee";
    }

    @Override
    public String updateEmployeeById(int id, Employee employee) {

        int status=1;
        String query;

        if(employee.getName() != null) {
            query = "update Employee set name = ? where id = ?";
            status = jdbcTemplate.update(query, employee.getName(), id);
        }
        if(employee.getDepartment() != null) {
            query = "update Employee set department = ? where id = ?";
            status = jdbcTemplate.update(query, employee.getDepartment(), id);
        }
        if(employee.getLocation() != null) {
            query = "update Employee set location = ? where id = ?";
            status = jdbcTemplate.update(query, employee.getLocation(), id);
        }
        if(status == 1){
            return "Employee updated successfully";
        }
        return "Employee with id " + id + " not found";

    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "select * from Employee";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<Employee>(Employee.class));
    }

}
