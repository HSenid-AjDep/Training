package org.example.springwithmongo.Service;


import org.example.springwithmongo.DTO.StudentRequestDTO;
import org.example.springwithmongo.DTO.StudentResponseDTO;
import org.example.springwithmongo.Entity.Student;
import org.example.springwithmongo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp1 implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentResponseDTO> getStudentById(String id) {
        return studentRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
        student.setAverage(studentRequestDTO.getAverage());

        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    private StudentResponseDTO convertToDTO(Student student) {
        StudentResponseDTO studentDTO = new StudentResponseDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setAverage(student.getAverage());
        return studentDTO;
    }
}
