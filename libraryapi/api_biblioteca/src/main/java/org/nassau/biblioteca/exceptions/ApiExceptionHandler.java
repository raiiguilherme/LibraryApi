package org.nassau.biblioteca.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.nassau.biblioteca.exceptions.ex.ConteudoNaoEncontrado;
import org.nassau.biblioteca.exceptions.ex.LimiteDePendenciaDeEmprestimos;
import org.nassau.biblioteca.exceptions.ex.LimiteMaximoDeEmprestimos;
import org.nassau.biblioteca.exceptions.ex.UsuarioComLivroEmprestado;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> camposInvalidos(MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campos invalidos", result));
    }
    @ExceptionHandler(ConteudoNaoEncontrado.class)
    public ResponseEntity<MessageError> conteudoNaoEncontrado(ConteudoNaoEncontrado ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }
    @ExceptionHandler(LimiteDePendenciaDeEmprestimos.class)
    public ResponseEntity<MessageError> conteudoNaoEncontrado(LimiteDePendenciaDeEmprestimos ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }

    @ExceptionHandler(LimiteMaximoDeEmprestimos.class)
    public ResponseEntity<MessageError> conteudoNaoEncontrado(LimiteMaximoDeEmprestimos ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }
    @ExceptionHandler(UsuarioComLivroEmprestado.class)
    public ResponseEntity<MessageError> conteudoNaoEncontrado(UsuarioComLivroEmprestado ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MessageError> cpfOrEmailAlreadyExist(DataIntegrityViolationException ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Email ja existe"));
    }


}
