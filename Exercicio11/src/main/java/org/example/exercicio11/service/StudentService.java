package org.example.exercicio11.service;

import org.example.exercicio11.model.Student;
import org.example.exercicio11.repository.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student criar(Student student) {
        return repository.save(student);
    }

    public List<Student> listar() {
        return repository.findAll();
    }

    public Student buscar(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Student atualizar(Long id, Student student) {
        Student existente = repository.findById(id).orElseThrow();
        existente.setNome(student.getNome());
        existente.setEmail(student.getEmail());
        existente.setIdade(student.getIdade());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
