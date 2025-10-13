package com.nous.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TDS_NOUS_PROGRESSO_TRILHA")
public class ProgressoTrilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progresso")
    private Long idProgresso;

    @Column(name = "st_trilha", nullable = false)
    private String stTrilha;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dtInicio;

    @Column(name = "dt_conclusao")
    private LocalDate dtConclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trilha", nullable = false)
    private Trilha trilha;

    public ProgressoTrilha() {}

    // Getters e Setters
    public Long getIdProgresso() { return idProgresso; }
    public void setIdProgresso(Long idProgresso) { this.idProgresso = idProgresso; }

    public String getStTrilha() { return stTrilha; }
    public void setStTrilha(String stTrilha) { this.stTrilha = stTrilha; }

    public LocalDate getDtInicio() { return dtInicio; }
    public void setDtInicio(LocalDate dtInicio) { this.dtInicio = dtInicio; }

    public LocalDate getDtConclusao() { return dtConclusao; }
    public void setDtConclusao(LocalDate dtConclusao) { this.dtConclusao = dtConclusao; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Trilha getTrilha() { return trilha; }
    public void setTrilha(Trilha trilha) { this.trilha = trilha; }
}
