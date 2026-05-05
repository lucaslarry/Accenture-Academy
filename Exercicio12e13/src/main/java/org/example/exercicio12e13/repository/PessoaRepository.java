package org.example.exercicio12e13.repository;


import org.example.exercicio12e13.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
