package com.nous.app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TDS_NOUS_TRILHA")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trilha")
    private Long idTrilha;

    @Column(name = "ds_titulo", nullable = false)
    private String dsTitulo;

    @Column(name = "ds_descricao", nullable = false)
    private String dsDescricao;

    @Column(name = "ds_categoria", nullable = false)
    private String dsCategoria;

    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProgressoTrilha> progressos;

    public Trilha() {}

    // Getters e Setters
    public Long getIdTrilha() { return idTrilha; }
    public void setIdTrilha(Long idTrilha) { this.idTrilha = idTrilha; }

    public String getDsTitulo() { return dsTitulo; }
    public void setDsTitulo(String dsTitulo) { this.dsTitulo = dsTitulo; }

    public String getDsDescricao() { return dsDescricao; }
    public void setDsDescricao(String dsDescricao) { this.dsDescricao = dsDescricao; }

    public String getDsCategoria() { return dsCategoria; }
    public void setDsCategoria(String dsCategoria) { this.dsCategoria = dsCategoria; }

    public List<ProgressoTrilha> getProgressos() { return progressos; }
    public void setProgressos(List<ProgressoTrilha> progressos) { this.progressos = progressos; }
}
