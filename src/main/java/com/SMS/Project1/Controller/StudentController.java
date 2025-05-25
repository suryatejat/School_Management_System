package com.SMS.Project1.Controller;

import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student newStudent){
//        System.out.println(newStudent);
        return studentService.addStudent(newStudent);
    }

    @GetMapping("/{id}")
    public Student getByStudentId(Long Id){
        return studentService.getByStudentId(Id);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        System.out.println(student.getId() + " " + student.getEmail());
        return studentService.UpdateByStudentId(student.getId(), student.getEmail());
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
