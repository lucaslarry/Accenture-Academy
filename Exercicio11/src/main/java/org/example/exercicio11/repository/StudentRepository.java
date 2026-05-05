package org.example.exercicio11.repository;


import org.example.exercicio11.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
