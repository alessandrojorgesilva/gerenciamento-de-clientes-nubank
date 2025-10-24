package br.com.alessandro.gerenciamento_de_clientes_nubank.dto;

import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosCliente(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,
        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
        String cpf,
        LocalDate dataNascimento
){

    public DadosCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
    }

}
