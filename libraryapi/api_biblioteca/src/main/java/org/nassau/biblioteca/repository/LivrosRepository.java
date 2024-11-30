package org.nassau.biblioteca.repository;

import org.nassau.biblioteca.domain.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {
}
