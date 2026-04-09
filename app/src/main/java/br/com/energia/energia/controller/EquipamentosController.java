package br.com.energia.energia.controller;

import br.com.energia.energia.model.Equipamentos;
import br.com.energia.energia.service.EquipamentosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentosController {

    private final EquipamentosService service;

    public EquipamentosController(EquipamentosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Equipamentos>> listarEquipamentos() {
        List<Equipamentos> equipamentos = service.getAllEquipamentos();
        return ResponseEntity.ok(equipamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamentos> getEquipamento(@PathVariable Long id) {
        try {
            Equipamentos equipamento = service.getEquipamentoById(id);
            return ResponseEntity.ok(equipamento);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
