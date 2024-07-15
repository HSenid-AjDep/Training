package org.example.springwithmongo.Service;
import org.example.springwithmongo.DTO.StudentRequestDTO;
import org.example.springwithmongo.DTO.StudentResponseDTO;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
    Optional<StudentResponseDTO> getStudentById(String id);
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
    void deleteStudent(String id);
}
