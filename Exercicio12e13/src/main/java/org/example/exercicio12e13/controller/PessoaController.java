package org.example.exercicio12e13.controller;

import jakarta.validation.Valid;
import org.example.exercicio12e13.model.Pessoa;
import org.example.exercicio12e13.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public Pessoa criar(@RequestBody @Valid Pessoa pessoa) {
        return service.criar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
        return service.atualizar(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
