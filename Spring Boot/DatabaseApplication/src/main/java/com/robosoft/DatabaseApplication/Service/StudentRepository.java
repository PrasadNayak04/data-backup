package com.robosoft.DatabaseApplication.Service;

import com.robosoft.DatabaseApplication.Modal.Student;

import java.util.List;

public interface StudentRepository {

    String addStudent(Student student);
    String deleteStudentById(int id);
    String updateStudentById(int id, Student student);

    List<Student> getAllStudents();

}
