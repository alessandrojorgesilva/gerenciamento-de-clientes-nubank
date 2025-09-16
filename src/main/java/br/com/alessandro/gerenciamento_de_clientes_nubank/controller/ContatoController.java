package br.com.alessandro.gerenciamento_de_clientes_nubank.controller;

import br.com.alessandro.gerenciamento_de_clientes_nubank.service.ClienteService;
import br.com.alessandro.gerenciamento_de_clientes_nubank.service.ContatoService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class ContatoController {

    @Autowired
    private ContatoService contatoService;
    @Autowired
    private ClienteService clienteService;


    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        contatoService.excluirContato(id);
        return ResponseEntity.noContent().build();
    }

}

