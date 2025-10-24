package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Contato;
import jakarta.validation.constraints.NotBlank;


public record DadosContato(
        @NotBlank(message = "Campo nome é obrigatório")
        String nome,
        @NotBlank(message = "Campo email é obrigatório")
        String email,
        @NotBlank(message = "Campo telefone é obrigatório")
        String telefone) {

    public DadosContato(Contato contato){
        this(contato.getNome(), contato.getEmail(), contato.getTelefone());
    }

}
