package org.example.exercicio11.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final org.example.exercicio11.service.StudentService service;

    public StudentController(org.example.exercicio11.service.StudentService service) {
        this.service = service;
    }

    @PostMapping
    public org.example.exercicio11.model.Student criar(@RequestBody org.example.exercicio11.model.Student student) {
        return service.criar(student);
    }

    @GetMapping
    public List<org.example.exercicio11.model.Student> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public org.example.exercicio11.model.Student buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public org.example.exercicio11.model.Student atualizar(@PathVariable Long id, @RequestBody org.example.exercicio11.model.Student student) {
        return service.atualizar(id, student);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}