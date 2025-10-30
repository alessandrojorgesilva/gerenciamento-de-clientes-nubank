package br.com.alessandro.gerenciamento_de_clientes_nubank.infra;

import br.com.alessandro.gerenciamento_de_clientes_nubank.dto.Erros;
import br.com.alessandro.gerenciamento_de_clientes_nubank.exceptions.EntidadeDuplicadaException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManipulaExcecoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(Erros::new));
    }

    @ExceptionHandler(EntidadeDuplicadaException.class)
    public ResponseEntity tratarErro409(EntidadeDuplicadaException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }



}
