package br.com.alessandro.gerenciamento_de_clientes_nubank.controller;


import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosCliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosContato;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosDetalamentoContato;
import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.DadosDetalhamentoCliente;
import br.com.alessandro.gerenciamento_de_clientes_nubank.repository.ClienteRepository;
import br.com.alessandro.gerenciamento_de_clientes_nubank.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoCliente> save(@RequestBody @Valid DadosCliente dados, UriComponentsBuilder componentsBuilder){
        var cliente = clienteService.salvar(dados);
        var uri = componentsBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

   @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCliente>> listarTodosClientes(){
        var lista = clienteService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCliente> getClienteId(@PathVariable Long id){
        var cliente = clienteService.getClientId(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCliente> atualizarCliente(@PathVariable Long id, @RequestBody @Valid DadosCliente dados){
        var cliente = clienteService.atualizarCliente(id, dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity ExcluirCLiente(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/contatos")
    public ResponseEntity<DadosDetalamentoContato> adicionarContato(@PathVariable Long id, @RequestBody @Valid DadosContato dados, UriComponentsBuilder uriComponentsBuilder){
        var contato = clienteService.adicionarContato(id, dados);
        var uri = uriComponentsBuilder.path("clientes/{id}/contatos/{idContato}").buildAndExpand(id, contato.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalamentoContato(contato));
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<DadosDetalamentoContato>> listarContatosCliente(@PathVariable Long id){
        var listaContatos = clienteService.listarContatosCliente(id);
        return ResponseEntity.ok(listaContatos);
    }

}
