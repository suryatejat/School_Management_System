package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Student UpdateByStudentId(Student student){
        Student existingStudent = getByStudentId(student.getId());
        existingStudent.setEmail(student.getEmail());
        return existingStudent;
    }


}
