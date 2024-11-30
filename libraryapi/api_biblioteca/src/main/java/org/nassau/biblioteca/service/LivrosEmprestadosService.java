package org.nassau.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.LivrosEmprestados;
import org.nassau.biblioteca.exceptions.ex.ConteudoNaoEncontrado;
import org.nassau.biblioteca.exceptions.ex.LimiteDePendenciaDeEmprestimos;
import org.nassau.biblioteca.repository.LivrosEmprestadosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LivrosEmprestadosService {

    private final LivrosEmprestadosRepository livrosEmprestadosRepository;
    private final LivrosService livrosService;
    private final UsuarioService usuarioService;

    public List<LivrosEmprestados> buscarTodosOsLivrosEmprestados(){
        return livrosEmprestadosRepository.findAll();
    }

    public LivrosEmprestados emprestarNovoLivro(Integer usuario_id, Integer livro_id, LocalDate dataDevolucao){

        var usuario = usuarioService.buscarUsuario(usuario_id);
        var livro = livrosService.buscarLivro(livro_id);
        var contagemDeEmprestimoPorUsuario = 0;

        for (LivrosEmprestados l: buscarTodosOsLivrosEmprestados()){
            if (Objects.equals(l.getUsuario().getId(), usuario.getId())){
                contagemDeEmprestimoPorUsuario += 1;
            }
            if (contagemDeEmprestimoPorUsuario>=2){
                throw new LimiteDePendenciaDeEmprestimos("Usuario ja possui o limite maximo de emprestimos");
            }
        }

        LivrosEmprestados livrosEmprestados = new LivrosEmprestados();
        livrosEmprestados.setLivro(livro);
        livrosEmprestados.setUsuario(usuario);
        livrosEmprestados.setDataDevolucao(dataDevolucao);

        livro.setVezes_emprestado(livro.getVezes_emprestado()+1);
        return livrosEmprestadosRepository.save(livrosEmprestados);

    }

    public void devolverLivro(Integer usuario_id, Integer livro_id){

        for (LivrosEmprestados l : this.buscarTodosOsLivrosEmprestados()){
            if (Objects.equals(l.getUsuario().getId(), usuario_id) && Objects.equals(l.getLivro().getId(), livro_id)){
                livrosEmprestadosRepository.delete(l);
                return;
            }

        }

        throw new ConteudoNaoEncontrado(
                "Nenhum usuario foi encontrado"
        );
    }





}
