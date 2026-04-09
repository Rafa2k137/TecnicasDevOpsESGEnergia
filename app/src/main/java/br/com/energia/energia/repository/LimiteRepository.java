package br.com.energia.energia.repository;

import br.com.energia.energia.domain.Limite;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LimiteRepository extends JpaRepository<Limite, Long> {

    @Modifying
    @Query("UPDATE Limite l SET l.idLimite = (l.idEquipamento * -1) WHERE l.idEquipamento = :idEquipamento")
    int limparIdLimite(@Param("idEquipamento") Long idEquipamento);
}
