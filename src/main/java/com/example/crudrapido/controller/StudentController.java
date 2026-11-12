package com.example.crudrapido.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrapido.entity.Study;
import com.example.crudrapido.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Método para obtener todos los registros (GET)
    @GetMapping
    public List<Study> getAll() {
        return studentService.getStudents();
    }

    // Método para obtener un registro específico por su ID (GET)
    @GetMapping("/{studyId}")
    public Optional<Study> getById(@PathVariable("studyId") Long studyId) {
        return studentService.getStudent(studyId);
    }

    // Método para guardar o actualizar un registro (POST)
    @PostMapping
    public void saveUpdate(@RequestBody Study study) {
        studentService.saveOrUpdateStudent(study);
    }

    // Método para eliminar un registro por su ID (DELETE)
    @DeleteMapping("/{studyId}")
    public void delete(@PathVariable("studyId") Long studyId) {
        studentService.delete(studyId);
    }
}