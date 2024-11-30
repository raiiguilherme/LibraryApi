package org.nassau.biblioteca.domain.dto;

import jakarta.validation.constraints.Email;

public record UsuarioDto(
        Integer id,
        String nome,
        String endereco,
        @Email(message = "Email em formato invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
        String email,
        String telefone

) {
}
