package org.example.exercicio14.service;

import org.example.exercicio14.interfaces.CepService;
import org.example.exercicio14.model.Endereco;
import org.example.exercicio14.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final CepService cepService;
    private final EnderecoRepository repository;

    public EnderecoService(CepService cepService, EnderecoRepository repository) {
        this.cepService = cepService;
        this.repository = repository;
    }

    public Endereco buscarESalvar(String cep) {
        Endereco endereco = cepService.buscarCep(cep);
        return repository.save(endereco);
    }

    public List<Endereco> listar() {
        return repository.findAll();
    }
}