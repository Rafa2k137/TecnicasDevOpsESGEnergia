package br.com.energia.energia.controller;

import br.com.energia.energia.domain.Manutencao;
import br.com.energia.energia.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    // POST /manutencoes/pendente
    @PostMapping("/pendente")
    public ResponseEntity<?> cadastrarManutencaoPendente(@RequestBody Manutencao manutencao) {
        try {
            Manutencao nova = manutencaoService.cadastrarManutencao(manutencao);
            return ResponseEntity.ok("✅ Manutenção cadastrada como PENDENTE com sucesso! ID: " + nova.getIdManutencao());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("❌ Erro ao cadastrar manutenção: " + e.getMessage());
        }
    }

    // PUT /manutencoes/concluida/{id}
    @PutMapping("/concluida/{id}")
    public ResponseEntity<?> concluirManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencaoAtualizada = manutencaoService.concluirManutencao(id);

        if (manutencaoAtualizada.isPresent()) {
            return ResponseEntity.ok("✅ Manutenção " + id + " atualizada para CONCLUÍDA com sucesso!");
        } else {
            return ResponseEntity.status(404).body("⚠️ Manutenção não encontrada ou já está concluída.");
        }
    }
}
