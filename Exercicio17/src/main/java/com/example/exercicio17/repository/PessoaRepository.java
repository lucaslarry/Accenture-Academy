package com.example.exercicio17.repository;


import com.example.exercicio17.model.Pessoa;
import com.example.exercicio17.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
