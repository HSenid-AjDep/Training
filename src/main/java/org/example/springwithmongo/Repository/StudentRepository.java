package org.example.springwithmongo.Repository;

import org.example.springwithmongo.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // Additional query methods (if any) can be defined here
}
