package br.com.energia.energia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CONSUMO")
public class Consumo {

    @Id
    @Column(name = "ID_CONSUMO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsumo;

    @Column(name = "ID_EQUIPAMENTO", nullable = false)
    private Long idEquipamento;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "MES", nullable = false)
    private Integer mes;

    @Column(name = "ANO", nullable = false)
    private Integer ano;

    @Column(name = "DT_REGISTRO")
    private LocalDate dtRegistro;

    // Getters e Setters
    public Long getIdConsumo() { return idConsumo; }
    public void setIdConsumo(Long idConsumo) { this.idConsumo = idConsumo; }

    public Long getIdEquipamento() { return idEquipamento; }
    public void setIdEquipamento(Long idEquipamento) { this.idEquipamento = idEquipamento; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public LocalDate getDtRegistro() { return dtRegistro; }
    public void setDtRegistro(LocalDate dtRegistro) { this.dtRegistro = dtRegistro; }
}
