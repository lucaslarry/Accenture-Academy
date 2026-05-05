package org.example.exercicio14.controller;


import org.example.exercicio14.model.Endereco;
import org.example.exercicio14.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cep")
public class CepRestController {

    private final EnderecoService service;

    public CepRestController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public Endereco buscarSalvar(@PathVariable String cep) {
        return service.buscarESalvar(cep);
    }

    @GetMapping
    public List<Endereco> listar() {
        return service.listar();
    }
}