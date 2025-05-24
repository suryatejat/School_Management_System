package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Student;
import com.SMS.Project1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

}
