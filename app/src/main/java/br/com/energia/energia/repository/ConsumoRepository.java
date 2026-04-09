package br.com.energia.energia.repository;

import br.com.energia.energia.model.Consumo;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
    List<Consumo> findByMesAndAno(int mes, int ano);
}