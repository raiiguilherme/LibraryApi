package org.nassau.biblioteca.repository;

import org.nassau.biblioteca.domain.EmprestimosPendentes;
import org.nassau.biblioteca.domain.LivrosEmprestados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosPendentesRepository extends JpaRepository<EmprestimosPendentes, Integer> {
}
