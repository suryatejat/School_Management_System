package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository  repository;

    public Courses save(Courses course) {
        return repository.save(course);
    }

    public Courses findById(Long id){
        return repository.findById(id).get();
    }

    public List<Courses> getAllCourses() {
        return repository.findAll();
    }

    public Courses deleteCourses(long id ){
        repository.deleteById(id);
        return null;
    }

    public Courses Updatedesc(Courses course) {
        Courses existingCourse = repository.findById(course.getId()).get();
        existingCourse.setDescription(course.getDescription());
        return existingCourse;
    }

}
