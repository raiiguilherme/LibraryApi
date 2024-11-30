package org.nassau.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.EmprestimosPendentes;
import org.nassau.biblioteca.domain.dto.EmprestimosPendentesDto;
import org.nassau.biblioteca.service.EmprestimosPendentesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emprestimos-pendentes")
public class EmprestimosPendentesController {

    private final EmprestimosPendentesService emprestimosPendentesService;

    @PostMapping("/criar")
    public ResponseEntity<EmprestimosPendentes> novoEmprestimoPendente(@RequestBody EmprestimosPendentesDto emprestimosPendentesDto){

        return ResponseEntity.status(201).body(emprestimosPendentesService.novoEmprestimoPendente(emprestimosPendentesDto.id_usuario(),
                emprestimosPendentesDto.id_livro()));
    }

    @GetMapping
    public ResponseEntity<List<EmprestimosPendentes>> buscarTodosEmprestimosPendentes(){
        return ResponseEntity.ok(emprestimosPendentesService.buscarTodosEmprestimosPendentes());
    }
}
