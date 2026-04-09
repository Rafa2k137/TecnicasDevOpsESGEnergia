package br.com.energia.energia.service;

import br.com.energia.energia.model.Equipamentos;
import br.com.energia.energia.repository.EquipamentosRepository;
import br.com.energia.energia.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentosService {

    private final EquipamentosRepository repository;

    public EquipamentosService(EquipamentosRepository repository) {
        this.repository = repository;
    }

    public List<Equipamentos> getAllEquipamentos() {
        return repository.findAll();
    }

    public Equipamentos getEquipamentoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com ID: " + id));
    }
}
