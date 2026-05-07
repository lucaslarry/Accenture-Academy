package com.example.exercicio17.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "O login é obrigatório")
        String login,

        @NotBlank(message = "A password é obrigatória")
        String password
){}