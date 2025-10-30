package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import org.springframework.validation.FieldError;

public record Erros(String campo, String mensagem) {
    public  Erros(FieldError erros){
        this(erros.getField(), erros.getDefaultMessage());
    }
}
