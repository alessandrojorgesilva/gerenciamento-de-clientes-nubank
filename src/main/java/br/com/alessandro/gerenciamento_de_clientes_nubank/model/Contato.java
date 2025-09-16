package br.com.alessandro.gerenciamento_de_clientes_nubank.model;


import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosContato;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Contato(DadosContato dadosContato, Cliente cliente) {
        this.nome = dadosContato.nome();
        this.email = dadosContato.email();
        this.telefone = dadosContato.telefone();
        this.cliente = cliente;
    }
}
