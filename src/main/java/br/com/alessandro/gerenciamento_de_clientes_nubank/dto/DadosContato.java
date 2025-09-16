package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Contato;


public record DadosContato(String nome, String email, String telefone) {

    public DadosContato(Contato contato){
        this(contato.getNome(), contato.getEmail(), contato.getTelefone());
    }

}
