package org.nassau.biblioteca.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record LivrosEmprestadosDto(

         Integer id,

         Integer id_usuario,
         Integer id_livro,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
         LocalDate dataDevolucao
) {
}
