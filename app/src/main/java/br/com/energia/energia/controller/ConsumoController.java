package br.com.energia.energia.controller;

import br.com.energia.energia.model.Consumo;
import br.com.energia.energia.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import br.com.energia.energia.exception.ResourceNotFoundException;
import java.util.List;



@RestController
@RequestMapping("/api/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @GetMapping("/agosto")
    public ResponseEntity<List<Consumo>> getConsumosAgosto() {
        List<Consumo> consumos = service.buscarConsumosAgosto();

        if (consumos.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum consumo encontrado para agosto de 2025");
        }

        return ResponseEntity.ok(consumos);
    }
}