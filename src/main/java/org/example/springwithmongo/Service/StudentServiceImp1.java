package org.example.springwithmongo.Service;

import org.example.springwithmongo.DTO.StudentDTO;
import org.example.springwithmongo.Entity.Student;
import org.example.springwithmongo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp1 implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return convertToDTO(student);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getDateOfBirth(), student.getAverage());
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getDateOfBirth(), studentDTO.getAverage());
    }
}
