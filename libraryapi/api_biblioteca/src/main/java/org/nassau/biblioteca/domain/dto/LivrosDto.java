package org.nassau.biblioteca.domain.dto;

public record LivrosDto(
  Integer id,
  String titulo,
  String autor,
  String genero,
  String ano_publicacao
) {
}
