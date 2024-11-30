package org.nassau.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.EmprestimosPendentes;
import org.nassau.biblioteca.exceptions.ex.LimiteDePendenciaDeEmprestimos;
import org.nassau.biblioteca.repository.EmprestimosPendentesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimosPendentesService {

    private final UsuarioService usuarioService;
    private final LivrosService livrosService;
    private final EmprestimosPendentesRepository emprestimosPendentesRepository;


    public List<EmprestimosPendentes> buscarTodosEmprestimosPendentes(){
        return emprestimosPendentesRepository.findAll();
    }


    public EmprestimosPendentes novoEmprestimoPendente(Integer id_usuario, Integer id_livro){

        var usuario = usuarioService.buscarUsuario(id_usuario);
        var livro = livrosService.buscarLivro(id_livro);

        for (EmprestimosPendentes e: this.buscarTodosEmprestimosPendentes()){
            if (e.getUsuario()==usuario){
                throw new LimiteDePendenciaDeEmprestimos("Limite maximo de emprestimos pendentes foi atingido");
            }
        }

        EmprestimosPendentes emprestimosPendentes = new EmprestimosPendentes();
        emprestimosPendentes.setUsuario(usuario);
        emprestimosPendentes.setLivro(livro);

        return emprestimosPendentesRepository.save(emprestimosPendentes);
    }




}
