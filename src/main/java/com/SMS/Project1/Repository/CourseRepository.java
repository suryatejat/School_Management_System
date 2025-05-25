package com.SMS.Project1.Repository;

import com.SMS.Project1.Model.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
    List<Courses> findByStudentId(Long studentId);
}
