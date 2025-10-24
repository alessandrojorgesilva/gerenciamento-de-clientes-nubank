package br.com.alessandro.gerenciamento_de_clientes_nubank.service;


import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.repository.ClienteRepository;
import br.com.alessandro.gerenciamento_de_clientes_nubank.repository.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    public Optional<Cliente> getClienteId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void excluirContato(Long id) {
        var contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não existe"));
        contatoRepository.delete(contato);
    }
}
