package br.com.energia.energia.service;

import br.com.energia.energia.model.Consumo;
import br.com.energia.energia.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

    public List<Consumo> buscarConsumosAgosto() {
        return repository.findByMesAndAno(8, 2025);
    }
}