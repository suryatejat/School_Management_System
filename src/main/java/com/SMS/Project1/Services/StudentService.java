package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Courses;
import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getByStudentId(Long id){
        return studentRepository.getReferenceById(id);
    }
    public Student UpdateByStudentId(long id, String email){
        Student existingStudent = getByStudentId(id);
        existingStudent.setEmail(email);
        studentRepository.save(existingStudent);
        return existingStudent;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public List<Courses> registeredCourses(Long id){
        return studentRepository.findById(id).get().getCourseList();
    }

}
