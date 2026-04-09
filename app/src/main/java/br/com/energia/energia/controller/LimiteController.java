package br.com.energia.energia.controller;

import br.com.energia.energia.service.LimiteService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/limites-consumo")
public class LimiteController {

    private final LimiteService service;

    public LimiteController(LimiteService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable @Positive Long id) {
        String mensagem = service.removerIdLimite(id);
        return ResponseEntity.ok(mensagem);
    }
}
