package br.com.alessandro.gerenciamento_de_clientes_nubank.exceptions;

public class EntidadeDuplicadaException extends RuntimeException{

    public EntidadeDuplicadaException(String mensagem){
        super(mensagem);
    }
}
