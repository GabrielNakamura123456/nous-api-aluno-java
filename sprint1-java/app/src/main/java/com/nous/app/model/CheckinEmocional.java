package com.nous.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TDS_NOUS_CHECKIN_EMOCIONAL")
public class CheckinEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkin")
    private Long idCheckin;

    @Column(name = "dt_checkin", nullable = false)
    private LocalDate dtCheckin;

    @Column(name = "nr_humor", nullable = false)
    private int nrHumor;

    @Column(name = "ds_comentario")
    private String dsComentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public CheckinEmocional() {}

    // Getters e Setters
    public Long getIdCheckin() { return idCheckin; }
    public void setIdCheckin(Long idCheckin) { this.idCheckin = idCheckin; }

    public LocalDate getDtCheckin() { return dtCheckin; }
    public void setDtCheckin(LocalDate dtCheckin) { this.dtCheckin = dtCheckin; }

    public int getNrHumor() { return nrHumor; }
    public void setNrHumor(int nrHumor) { this.nrHumor = nrHumor; }

    public String getDsComentario() { return dsComentario; }
    public void setDsComentario(String dsComentario) { this.dsComentario = dsComentario; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
