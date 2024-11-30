package org.nassau.biblioteca.exceptions.ex;

public class UsuarioComLivroEmprestado extends RuntimeException{
    public UsuarioComLivroEmprestado(String s){
        super(s);
    }
}
