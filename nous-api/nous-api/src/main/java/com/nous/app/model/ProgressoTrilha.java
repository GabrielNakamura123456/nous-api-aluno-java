package com.nous.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

/**
 * Entidade que representa o progresso de um usuário em uma trilha de aprendizado.
 * Relaciona-se com as tabelas de Usuário e Trilha.
 */
@Entity
@Table(name = "TDS_NOUS_PROGRESSO_TRILHA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressoTrilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progresso")
    private Long idProgresso;

    @NotBlank(message = "O status da trilha é obrigatório.")
    @Size(max = 50, message = "O status da trilha deve ter no máximo 50 caracteres.")
    @Column(name = "st_trilha", nullable = false)
    private String stTrilha;

    @NotNull(message = "A data de início é obrigatória.")
    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dtInicio;

    @Column(name = "dt_conclusao")
    private LocalDate dtConclusao;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trilha", nullable = false)
    private Trilha trilha;
}
