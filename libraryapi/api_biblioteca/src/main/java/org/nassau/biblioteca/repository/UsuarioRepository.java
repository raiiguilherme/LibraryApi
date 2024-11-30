package org.nassau.biblioteca.repository;

import org.nassau.biblioteca.domain.Livros;
import org.nassau.biblioteca.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
