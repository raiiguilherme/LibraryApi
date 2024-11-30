package org.nassau.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.LivrosEmprestados;
import org.nassau.biblioteca.domain.Usuario;
import org.nassau.biblioteca.domain.dto.LivrosEmprestadosDto;
import org.nassau.biblioteca.domain.dto.UsuarioDto;
import org.nassau.biblioteca.service.LivrosEmprestadosService;
import org.nassau.biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class LivrosEmprestadorController {

    private final LivrosEmprestadosService livrosEmprestadosService;

    @PostMapping("/emprestar")
    public ResponseEntity<LivrosEmprestados> emprestarNovoLivro(@RequestBody LivrosEmprestadosDto livrosEmprestadosDto){

    return ResponseEntity.status(201).body(livrosEmprestadosService.emprestarNovoLivro(livrosEmprestadosDto.id_usuario(), livrosEmprestadosDto.id_livro(),livrosEmprestadosDto.dataDevolucao()));

    }

    @GetMapping
    public ResponseEntity<List<LivrosEmprestados>> buscarTodosLivrosEmprestados(){
        return ResponseEntity.ok(livrosEmprestadosService.buscarTodosOsLivrosEmprestados());
    }

    @DeleteMapping("/devolver/{idDoUsuario}/{idDoLivro}")
    public ResponseEntity<Void> devolverLivro(@PathVariable Integer idDoUsuario, @PathVariable  Integer idDoLivro ){
        livrosEmprestadosService.devolverLivro(idDoUsuario, idDoLivro);
        return ResponseEntity.ok().build();
    }

}
