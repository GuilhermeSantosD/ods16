package com.unijorge.ods16.model.records;

import com.unijorge.ods16.model.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewEmployee (
        @NotBlank
        String nome,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String senha,
        @NotNull
        Cargo funcao
){
}
