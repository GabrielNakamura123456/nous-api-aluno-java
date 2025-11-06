package com.nous.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TDS_NOUS_CHECKIN_EMOCIONAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckinEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkin")
    private Long idCheckin;

    @NotNull(message = "A data do check-in é obrigatória.")
    @Column(name = "dt_checkin", nullable = false)
    private LocalDate dtCheckin;

    @Min(value = 1, message = "O humor deve ser no mínimo 1.")
    @Max(value = 10, message = "O humor deve ser no máximo 10.")
    @Column(name = "nr_humor", nullable = false)
    private int nrHumor;

    @Size(max = 255, message = "O comentário deve ter no máximo 255 caracteres.")
    @Column(name = "ds_comentario")
    private String dsComentario;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
