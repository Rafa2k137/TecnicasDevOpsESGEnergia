package br.com.energia.energia.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LIMITE")
public class Limite {

    @Id
    @Column(name = "ID_EQUIPAMENTO")
    private Long idEquipamento; // 🔹 PK real

    @Column(name = "ID_LIMITE", nullable = true)
    private Long idLimite; // 🔹 Campo que será "limpo" (setado para NULL)

    @Column(name = "VALOR_LIMITE")
    private Double valorLimite;
}
