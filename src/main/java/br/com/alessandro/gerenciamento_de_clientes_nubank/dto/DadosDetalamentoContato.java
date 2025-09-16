package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Contato;

public record DadosDetalamentoContato(Long id, String nome, String email, String telefone) {

    public DadosDetalamentoContato(Contato contato){
        this(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone());
    }

}

