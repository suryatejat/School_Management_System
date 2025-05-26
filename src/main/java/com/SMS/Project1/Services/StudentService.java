package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getByStudentId(Long id) throws UsernameNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Student not found"));
    }

    public Student UpdateByStudentId(long id, String email){
        Student existingStudent = getByStudentId(id);
        existingStudent.setEmail(email);
        return studentRepository.save(existingStudent);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<Courses> registeredCourses(Long id){
        return studentRepository.findById(id).get().getCourseList();
    }


    public Student findByEmail(String email){
        return studentRepository.findByEmail(email).orElseThrow(null);
}
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findStudentByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .build();
    }
}
