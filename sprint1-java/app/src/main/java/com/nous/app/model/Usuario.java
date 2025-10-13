package com.nous.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TDS_NOUS_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nm_usuario", nullable = false)
    private String nmUsuario;

    @Column(name = "ds_email", nullable = false, unique = true)
    private String dsEmail;

    @Column(name = "ds_senha", nullable = false)
    private String dsSenha;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CheckinEmocional> checkins;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProgressoTrilha> progressos;

    public Usuario() {}

    // Getters e Setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNmUsuario() { return nmUsuario; }
    public void setNmUsuario(String nmUsuario) { this.nmUsuario = nmUsuario; }

    public String getDsEmail() { return dsEmail; }
    public void setDsEmail(String dsEmail) { this.dsEmail = dsEmail; }

    public String getDsSenha() { return dsSenha; }
    public void setDsSenha(String dsSenha) { this.dsSenha = dsSenha; }

    public LocalDate getDtNascimento() { return dtNascimento; }
    public void setDtNascimento(LocalDate dtNascimento) { this.dtNascimento = dtNascimento; }

    public List<CheckinEmocional> getCheckins() { return checkins; }
    public void setCheckins(List<CheckinEmocional> checkins) { this.checkins = checkins; }

    public List<ProgressoTrilha> getProgressos() { return progressos; }
    public void setProgressos(List<ProgressoTrilha> progressos) { this.progressos = progressos; }
}
