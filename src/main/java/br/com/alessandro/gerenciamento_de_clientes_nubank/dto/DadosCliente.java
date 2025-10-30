package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DadosCliente(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,
        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
        String cpf,
        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate dataNascimento
){

    public DadosCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
    }

}
