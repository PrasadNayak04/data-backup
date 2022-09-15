package com.robosoft.DatabaseApplication.Service;

import com.robosoft.DatabaseApplication.Modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String addStudent(Student student) {
        String query = "insert into Student values(?,?,?)";
        int status = jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
        if(status == 1){
            return "Employee added successfully";
        }
        return "Failed to add the employee";
    }

    @Override
    public String deleteStudentById(int id) {
        String query = "delete from Student where id = ?";
        int status = jdbcTemplate.update(query,id);
        if(status == 1){
            return "Employee deleted successfully";
        }
        return "Failed to delete the employee";
    }

    @Override
    public String updateStudentById(int id, Student student) {
        String query = "update Student set name = ?, address = ? where id = ?";
        int status = jdbcTemplate.update(query,student.getName(),student.getAddress(),id);
        if(status == 1){
            return "Employee updated successfully";
        }
        return "Failed to update the employee";
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from Student";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<Student>(Student.class));
    }

}
