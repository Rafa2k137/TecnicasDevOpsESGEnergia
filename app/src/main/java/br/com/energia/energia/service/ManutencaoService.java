package br.com.energia.energia.service;

import br.com.energia.energia.domain.Manutencao;
import br.com.energia.energia.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    // Cadastrar nova manutenção pendente
    public Manutencao cadastrarManutencao(Manutencao manutencao) {
        manutencao.setStatusManutencao("PENDENTE");
        return manutencaoRepository.save(manutencao);
    }

    // Atualizar manutenção para concluída
    public Optional<Manutencao> concluirManutencao(Long id) {
        Optional<Manutencao> manutencaoOpt = manutencaoRepository.findById(id);

        if (manutencaoOpt.isPresent()) {
            Manutencao manutencao = manutencaoOpt.get();

            if ("PENDENTE".equalsIgnoreCase(manutencao.getStatusManutencao())) {
                manutencao.setStatusManutencao("CONCLUIDA");
                manutencaoRepository.save(manutencao);
                return Optional.of(manutencao);
            }
        }
        return Optional.empty();
    }
}
