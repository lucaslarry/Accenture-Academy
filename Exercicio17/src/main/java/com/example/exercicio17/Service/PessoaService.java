package com.example.exercicio17.Service;

import com.example.exercicio17.model.Pessoa;
import com.example.exercicio17.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
    }

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa update(Long id, Pessoa pessoaDetails) {
        Pessoa pessoa = findById(id);
        pessoa.setNome(pessoaDetails.getNome());
        pessoa.setEmail(pessoaDetails.getEmail());
        return repository.save(pessoa);
    }

    public void delete(Long id) {
        Pessoa pessoa = findById(id);
        repository.delete(pessoa);
    }
}