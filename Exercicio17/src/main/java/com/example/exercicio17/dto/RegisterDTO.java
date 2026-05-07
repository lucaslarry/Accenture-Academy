package com.example.exercicio17.dto;

import com.example.exercicio17.model.enums.UserRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegisterDTO(
        @NotBlank(message = "O login é obrigatório")
        String login,

        @NotBlank(message = "A password é obrigatória")
        String password,

        @NotNull(message = "O papel (role) do utilizador é obrigatório")
        UserRoles role
) {}