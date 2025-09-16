package br.com.alessandro.gerenciamento_de_clientes_nubank.repository;


import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @Query("select c from Contato c where c.cliente.id = :id")
    List<Contato> buscaContatosPorId(Long id);

    List<Contato> findByClienteId(Long clienteId);
}

