package org.nassau.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.nassau.biblioteca.domain.Livros;
import org.nassau.biblioteca.domain.Usuario;
import org.nassau.biblioteca.exceptions.ex.ConteudoNaoEncontrado;
import org.nassau.biblioteca.exceptions.ex.UsuarioComLivroEmprestado;
import org.nassau.biblioteca.repository.LivrosRepository;
import org.nassau.biblioteca.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario adicionarNovoUsuario(Usuario usuario){
       return repository.save(usuario);

    }

    public List<Usuario> buscarTodosUsuarios(){
        return repository.findAll();
    }


    public Usuario buscarUsuario(Integer id){

        return repository.findById(id).orElseThrow(
                () -> new ConteudoNaoEncontrado("Id nâo encontrado")
        );
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuario){
       Usuario usuario_para_atualizar = this.buscarUsuario(id);

       if (usuario.getEmail()!=null){
           usuario_para_atualizar.setEmail(usuario.getEmail());
       }
       if (usuario.getEndereco() != null){
           usuario_para_atualizar.setEndereco(usuario.getEndereco());
       }
       if (usuario.getNome() != null){
           usuario_para_atualizar.setNome(usuario.getNome());
       }
       if (usuario.getTelefone()!= null) {
           usuario_para_atualizar.setTelefone(usuario.getTelefone());
       }

      return repository.save(usuario_para_atualizar);
    }

    public void deletarUsuario(Integer id){
        var usuario = this.buscarUsuario(id);
        try {
            repository.delete(usuario);
        }
        catch (DataIntegrityViolationException e){

            throw new UsuarioComLivroEmprestado("Usuario nao pode ser deletado sem antes devolver seus livros");
        }

    }


}
