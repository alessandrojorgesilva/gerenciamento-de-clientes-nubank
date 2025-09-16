package br.com.alessandro.gerenciamento_de_clientes_nubank.service;

import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosCliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosContato;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosDetalamentoContato;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosDetalhamentoCliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Cliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.model.Contato;
import br.com.alessandro.gerenciamento_de_clientes_nubank.repository.ClienteRepository;
import br.com.alessandro.gerenciamento_de_clientes_nubank.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public Cliente salvar(DadosCliente dados) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(dados.cpf());
        if(cliente.isPresent()){
            throw  new RuntimeException("Cliente já existe");
        }
        return clienteRepository.save(new Cliente(dados));
    }

    public List<DadosDetalhamentoCliente> listarTodos() {
        var lista = clienteRepository.buscarTodos();
        return lista.stream()
                .map(DadosDetalhamentoCliente::new)
                .toList();
    }

    public Cliente getClientId(Long id) {
        return clienteRepository.getReferenceById(id);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, DadosCliente dados) {
        var cliente = clienteRepository.getReferenceById(id);

        if (dados.nome() != null){
            cliente.setNome(dados.nome());
        }
        if(dados.cpf() != null){
            cliente.setCpf(dados.cpf());
        }
        if(dados.dataNascimento() != null){
            cliente.setDataNascimento(dados.dataNascimento());
        }
        return cliente;
    }

    @Transactional
    public Contato adicionarContato(Long id, DadosContato dadosContato) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Contato contato = new Contato(dadosContato, cliente);
        contatoRepository.save(contato);
        return contato;
    }

    public List<DadosDetalamentoContato> listarContatosCliente(Long id) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        return cliente.getContatos().stream()
                .map(DadosDetalamentoContato::new)
                .toList();
    }

}
