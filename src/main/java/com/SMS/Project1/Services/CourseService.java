package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository  repository;
    @Autowired
    private StudentService studentService;

    public Courses save(Courses course) {
        return repository.save(course);
    }

    public Optional<Courses> findById(Long id){
        return repository.findById(id);

    }

    public List<Courses> getAllCourses() {
        return repository.findAll();
    }
    public Optional<Courses> deleteCourses(long id ){
        repository.deleteById(id);
        return null;
    }

    public Optional<Courses> Updatedesc(Courses course) {
        Optional<Courses> existingCourse = repository.findById(course.getId());
        System.out.println(existingCourse);
        return existingCourse;
    }

    public List<Courses> findByStudentId(String email){
        Student student = studentService.findByEmail(email);
        return repository.findByStudentId(student.getId());
    }
}
