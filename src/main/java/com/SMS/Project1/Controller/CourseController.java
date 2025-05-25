package com.SMS.Project1.Controller;


import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    private Courses createCourse(@RequestBody Courses course) {
        return courseService.save(course);
    }

    @PutMapping("/update")
    private Optional<Courses> UpdateDescription(@RequestBody Courses course) {
        return courseService.Updatedesc(course);
    }

    @GetMapping("/{id}")
    private Optional<Courses> FindCourse(@PathVariable Long id){
        return courseService.findById(id);
    }
    @DeleteMapping("/{id}")
    private Optional<Courses> DeleteCourse(@PathVariable Long id){
        return courseService.deleteCourses(id);
    }



}