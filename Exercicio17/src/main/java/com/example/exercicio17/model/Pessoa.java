package com.example.exercicio17.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
}