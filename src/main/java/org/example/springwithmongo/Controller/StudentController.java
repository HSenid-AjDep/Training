package org.example.springwithmongo.Controller;

import org.example.springwithmongo.DTO.StudentRequestDTO;
import org.example.springwithmongo.DTO.StudentResponseDTO;
import org.example.springwithmongo.Exception.ResourceNotFoundException;
import org.example.springwithmongo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        StudentResponseDTO createdStudentDTO = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}