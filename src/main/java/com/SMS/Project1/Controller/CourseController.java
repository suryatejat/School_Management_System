package com.SMS.Project1.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    private Courses createCourse(@RequestBody Courses course) {
        return courseService.save(course);
    }

    @PutMapping("/update")
    private Courses UpdateDescription(@RequestBody Courses course) {
        return courseService.Updatedesc(course);
    }

    @GetMapping("/{id}")
    private Courses FindCourse(@PathVariable Long id){
        return courseService.findById(id);
    }
    @DeleteMapping("/{id}")
    private Courses DeleteCourse(@PathVariable Long id){
        return courseService.deleteCourses(id);
    }
}