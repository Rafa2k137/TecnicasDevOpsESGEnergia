package br.com.energia.energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.energia.energia.model.Equipamentos;

public interface EquipamentosRepository extends JpaRepository<Equipamentos, Long> {
}
