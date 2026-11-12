package com.example.crudrapido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudrapido.entity.Study;
import com.example.crudrapido.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Study> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Study> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public void saveOrUpdateStudent(Study study) {
        studentRepository.save(study);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}