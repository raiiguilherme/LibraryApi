package org.nassau.biblioteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nassau.biblioteca.domain.dto.LivrosDto;

@Entity
@Table(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String autor;
    private String genero;
    private String ano_publicacao;
    private Integer vezes_emprestado;



    public Livros(LivrosDto livrosDto){
         this.id = livrosDto.id();
         this.titulo = livrosDto.titulo();
        this.autor = livrosDto.autor();
        this.genero = livrosDto.genero();
        this.ano_publicacao = livrosDto.ano_publicacao();
        this.vezes_emprestado = 0;


    }

}
