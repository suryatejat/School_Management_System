package com.SMS.Project1.Repository;

import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Model.Student;
import jakarta.persistence.Id;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Optional<Student> findByEmail(String email);
}
