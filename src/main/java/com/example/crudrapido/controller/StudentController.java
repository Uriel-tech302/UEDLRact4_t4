package com.example.crudrapido.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrapido.dto.StudentDto;
import com.example.crudrapido.entity.Study;
import com.example.crudrapido.service.StudentService;

import jakarta.validation.Valid;

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
public ResponseEntity<?> saveUpdate(@Valid @RequestBody StudentDto studentDto) {
    
    // 1. Mapeamos los datos del DTO hacia tu entidad Study
    Study study = new Study();
    study.setFirstName(studentDto.getFirstName());
    study.setLastName(studentDto.getLastName());
    study.setEmail(studentDto.getEmail());

    // 2. Guardamos en la base de datos usando tu servicio
    studentService.saveOrUpdateStudent(study); // Asegúrate de usar el nombre exacto de tu método de servicio
    
    // 3. Devolvemos el JSON de éxito
    return ResponseEntity.ok(Map.of("mensaje", "Estudiante guardado exitosamente."));
}
    // Método para eliminar un registro por su ID (DELETE)
    @DeleteMapping("/{studyId}")
    public ResponseEntity<?> delete(@PathVariable("studyId") Long studyId) {
        studentService.delete(studyId);
        return ResponseEntity.ok(Map.of("mensaje", "Estudiante eliminado exitosamente."));
    }
}