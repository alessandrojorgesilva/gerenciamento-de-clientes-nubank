package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;

public record DadosCliente(String nome, String cpf, String dataNascimento) {

    public DadosCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
    }

}
