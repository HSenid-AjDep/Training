package org.example.springwithmongo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    private String name;
    private LocalDate dateOfBirth;
    private double average;
}
