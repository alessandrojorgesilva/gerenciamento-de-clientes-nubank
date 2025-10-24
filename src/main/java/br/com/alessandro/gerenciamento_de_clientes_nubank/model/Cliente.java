package br.com.alessandro.gerenciamento_de_clientes_nubank.model;


import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosCliente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    public Cliente(DadosCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
    }

}
