package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;


import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;

public record DadosDetalhamentoCliente (Long id, String nome, String cpf, String dataNascimento){

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
    }
}
