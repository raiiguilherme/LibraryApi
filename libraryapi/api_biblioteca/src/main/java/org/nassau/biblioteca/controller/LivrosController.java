package org.nassau.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.Livros;
import org.nassau.biblioteca.domain.dto.LivrosDto;
import org.nassau.biblioteca.service.LivrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivrosController {

    private final LivrosService livrosService;

    @PostMapping("/criar")
    public ResponseEntity<Livros> criarNovoLivro(@RequestBody LivrosDto livrosDto){

    Livros livros = new Livros(livrosDto);
    return ResponseEntity.status(201).body(livrosService.adicionarNovoLivro(livros));

    }

    @GetMapping
    public ResponseEntity<List<Livros>> buscarTodosLivros(){
        return ResponseEntity.ok(livrosService.buscarTodosLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livros> buscarLivro(@PathVariable Integer id){
        return ResponseEntity.ok(livrosService.buscarLivro(id));
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Livros> atualizarLivro(@PathVariable Integer id, @RequestBody LivrosDto livrosDto){
        Livros livros = new Livros(livrosDto);
       return ResponseEntity.ok(livrosService.atualizarLivro(id, livros));

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Integer id){
        livrosService.deletarLivro(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/mais-emprestados")
    public ResponseEntity<List<Livros>> buscarLivrosMaisEmprestados(){
        return ResponseEntity.ok(livrosService.livrosMaisEmprestados());
    }




}
