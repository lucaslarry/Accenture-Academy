package org.example.exercicio16.controller;


import jakarta.validation.Valid;
import org.example.exercicio16.model.Aluno;
import org.example.exercicio16.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@Valid @RequestBody Aluno aluno) {
        Aluno savedAluno = service.saveAluno(aluno);
        return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno() {
        return ResponseEntity.ok(service.getAllAluno());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Integer id, @Valid @RequestBody Aluno alunoDetails) {
        Aluno updatedAluno = service.updateAluno(id, alunoDetails);
        return ResponseEntity.ok(updatedAluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Integer id) {
        service.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
