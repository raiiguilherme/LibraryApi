package org.nassau.biblioteca.repository;

import org.nassau.biblioteca.domain.LivrosEmprestados;
import org.nassau.biblioteca.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosEmprestadosRepository extends JpaRepository<LivrosEmprestados, Integer> {
}
