package com.SMS.Project1.Controller;

import com.SMS.Project1.Model.Teacher;
import com.SMS.Project1.Repository.TeacherRepository;
import com.SMS.Project1.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    private Teacher getTeacher(@PathVariable(name = "id") long teacherId) {
        return teacherService.findById(teacherId);
    }

    @GetMapping("/")
    private List<Teacher> getTeachers() {
        return teacherService.findAll();
    }

    @PostMapping("/")
    private Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }
}
