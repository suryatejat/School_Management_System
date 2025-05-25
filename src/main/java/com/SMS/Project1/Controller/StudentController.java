package com.SMS.Project1.Controller;

import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/signup")
    public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam String password){
//        System.out.println(newStudent);
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setEmail(email);
        newStudent.setPassword(passwordEncoder.encode(password));
        studentService.addStudent(newStudent);
        return "redirect:/login";
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

    @GetMapping("/dashboard")
    public String getDashboard(){
        studentService.getAllStudents();
        return "dashboard";
    }
}
