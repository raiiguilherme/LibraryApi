package org.nassau.biblioteca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.Livros;
import org.nassau.biblioteca.domain.Usuario;
import org.nassau.biblioteca.domain.dto.LivrosDto;
import org.nassau.biblioteca.domain.dto.UsuarioDto;
import org.nassau.biblioteca.service.LivrosService;
import org.nassau.biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criarNovoUsuario(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = new Usuario(usuarioDto);
    return ResponseEntity.status(201).body(usuarioService.adicionarNovoUsuario(usuario));

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuario(id));
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody @Valid UsuarioDto usuarioDto){
        Usuario usuario = new Usuario(usuarioDto);
       return ResponseEntity.ok(usuarioService.atualizarUsuario(id,usuario));

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();

    }




}
