package br.com.energia.energia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EQUIPAMENTOS")
public class Equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPAMENTO")
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    @Column(name = "NOME")
    private String nome;

    @NotBlank(message = "Tipo é obrigatório")
    @Size(max = 50, message = "Tipo não pode ter mais de 50 caracteres")
    @Column(name = "TIPO")
    private String tipo;

    @NotNull(message = "Potência é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "Potência deve ser maior que 0")
    @Column(name = "POTENCIA_KW")
    private BigDecimal potenciaKw;

    @NotNull(message = "Data de instalação é obrigatória")
    @Column(name = "DT_INSTALACAO")
    private LocalDate dtInstalacao;

    @NotBlank(message = "Status é obrigatório")
    @Column(name = "STATUS_EQUIPAMENTO")
    private String status;

    @NotNull(message = "Data de registro é obrigatória")
    @Column(name = "DT_REGISTRO")
    private LocalDateTime dtRegistro;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public BigDecimal getPotenciaKw() { return potenciaKw; }
    public void setPotenciaKw(BigDecimal potenciaKw) { this.potenciaKw = potenciaKw; }

    public LocalDate getDtInstalacao() { return dtInstalacao; }
    public void setDtInstalacao(LocalDate dtInstalacao) { this.dtInstalacao = dtInstalacao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDtRegistro() { return dtRegistro; }
    public void setDtRegistro(LocalDateTime dtRegistro) { this.dtRegistro = dtRegistro; }
}