package com.nous.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TDS_NOUS_TRILHA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trilha")
    private Long idTrilha;

    @NotBlank(message = "O título da trilha é obrigatório.")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres.")
    @Column(name = "ds_titulo", nullable = false)
    private String dsTitulo;

    @NotBlank(message = "A descrição da trilha é obrigatória.")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    @Column(name = "ds_descricao", nullable = false)
    private String dsDescricao;

    @NotBlank(message = "A categoria da trilha é obrigatória.")
    @Size(max = 100, message = "A categoria deve ter no máximo 100 caracteres.")
    @Column(name = "ds_categoria", nullable = false)
    private String dsCategoria;


    @JsonIgnore
    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProgressoTrilha> progressos;
}
