package com.SMS.Project1.Repository;

import com.SMS.Project1.Model.Courses;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository <Courses, Long>{

}
