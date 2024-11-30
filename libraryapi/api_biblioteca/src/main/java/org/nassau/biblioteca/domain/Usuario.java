package org.nassau.biblioteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nassau.biblioteca.domain.dto.UsuarioDto;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String endereco;
    @Column(unique = true)
    private String email;
    private String telefone;
    public Usuario(UsuarioDto dto){

        this.id = dto.id();
        this.email = dto.email();
        this.endereco = dto.endereco();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
    }

}
