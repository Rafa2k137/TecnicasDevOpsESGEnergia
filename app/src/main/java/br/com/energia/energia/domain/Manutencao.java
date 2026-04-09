package br.com.energia.energia.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MANUTENCAO")
public class Manutencao {

    @Id
    @Column(name = "ID_MANUTENCAO")
    private Long idManutencao;

    @Column(name = "ID_EQUIPAMENTO", nullable = false)
    private Long idEquipamento;

    @Column(name = "DT_MANUTENCAO", nullable = false)
    private LocalDate dataManutencao;

    @Column(name = "DT_VALIDADE", nullable = false)
    private LocalDate dataValidade;

    @Column(name = "TIPO_MANUTENCAO", nullable = false)
    private String tipoManutencao;

    @Column(name = "STATUS_MANUTENCAO", nullable = false)
    private String statusManutencao;

    // Getters e Setters manuais
    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public String getStatusManutencao() {
        return statusManutencao;
    }

    public void setStatusManutencao(String statusManutencao) {
        this.statusManutencao = statusManutencao;
    }
}
