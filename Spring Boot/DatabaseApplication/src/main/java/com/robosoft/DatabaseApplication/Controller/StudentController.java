package com.robosoft.DatabaseApplication.Controller;

import com.robosoft.DatabaseApplication.Modal.Student;
import com.robosoft.DatabaseApplication.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prasad/springboot/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudentById(@PathVariable int id, @RequestBody Student updatedStudent){
        return studentService.updateStudentById(id, updatedStudent);
    }

}
