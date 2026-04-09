package br.com.energia.energia.service;

import br.com.energia.energia.exception.NotFoundException;
import br.com.energia.energia.repository.LimiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LimiteService {

    private final LimiteRepository limiteRepository;

    public LimiteService(LimiteRepository limiteRepository) {
        this.limiteRepository = limiteRepository;
    }

    @Transactional
    public String removerIdLimite(Long idEquipamento) {
        int alterados = limiteRepository.limparIdLimite(idEquipamento);

        if (alterados == 0) {
            throw new NotFoundException("❌ O ID informado não existe ou já está com ID_LIMITE = 0");
        }

        return "✅ ID limite removido com sucesso!";
    }
}
