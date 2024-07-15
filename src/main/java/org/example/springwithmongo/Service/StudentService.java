package org.example.springwithmongo.Service;

import org.example.springwithmongo.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(String id);
    StudentDTO createStudent(StudentDTO studentDTO);
    void deleteStudent(String id);
}
