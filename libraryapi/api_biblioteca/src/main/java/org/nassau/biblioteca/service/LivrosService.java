package org.nassau.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.Livros;
import org.nassau.biblioteca.exceptions.ex.ConteudoNaoEncontrado;
import org.nassau.biblioteca.repository.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivrosService {

    private final LivrosRepository repository;

    public Livros adicionarNovoLivro(Livros livros){
       return repository.save(livros);

    }

    public List<Livros> buscarTodosLivros(){
        return repository.findAll();
    }


    public Livros buscarLivro(Integer id){

        return repository.findById(id).orElseThrow(
                () -> new ConteudoNaoEncontrado("Id nâo encontrado")
        );
    }

    public Livros atualizarLivro(Integer id, Livros livros){
       Livros book_para_atualizar = this.buscarLivro(id);

       if (livros.getAno_publicacao()!= null){
           book_para_atualizar.setAno_publicacao(livros.getAno_publicacao());
       }
       if (livros.getAutor() != null){
           book_para_atualizar.setAutor(livros.getAutor());
       }
       if (livros.getGenero() != null){
           book_para_atualizar.setGenero(livros.getGenero());
       }
       if (livros.getTitulo()!= null) {
           book_para_atualizar.setTitulo(livros.getTitulo());
       }

      return repository.save(book_para_atualizar);
    }

    public void deletarLivro(Integer id){
        var livro = this.buscarLivro(id);
        repository.delete(livro);
    }

    public List<Livros> livrosMaisEmprestados(){
        var list = this.buscarTodosLivros();

        return list.stream()
                .sorted(Comparator.comparing(Livros::getVezes_emprestado).reversed())
                .collect(Collectors.toList());

    }


}
