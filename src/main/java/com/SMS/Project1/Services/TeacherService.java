package com.SMS.Project1.Services;

import com.SMS.Project1.Model.Teacher;
import com.SMS.Project1.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public Teacher findById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    public void delete(Teacher teacher) {
        repository.delete(teacher);
    }

    public Teacher update(Teacher teacher) {
        return repository.save(teacher);
    }
}
