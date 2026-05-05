package org.example.exercicio12e13.service;

import org.example.exercicio12e13.model.Pessoa;
import org.example.exercicio12e13.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa criar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Pessoa buscar(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        Pessoa existente = repository.findById(id).orElseThrow();
        existente.setNome(pessoa.getNome());
        existente.setEmail(pessoa.getEmail());
        existente.setIdade(pessoa.getIdade());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
