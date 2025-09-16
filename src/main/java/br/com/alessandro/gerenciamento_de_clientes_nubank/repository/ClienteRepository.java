package br.com.alessandro.gerenciamento_de_clientes_nubank.repository;


import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c")
    List<Cliente> buscarTodos();

    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Cliente getClienteId(Long id);

    Optional<Cliente> findByCpf(String cpf);


}
