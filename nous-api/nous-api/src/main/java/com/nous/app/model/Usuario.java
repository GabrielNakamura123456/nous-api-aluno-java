package com.nous.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TDS_NOUS_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Column(name = "nm_usuario", nullable = false)
    private String nmUsuario;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Column(name = "ds_email", nullable = false, unique = true)
    private String dsEmail;

    @NotBlank(message = "A senha é obrigatória")
    @Column(name = "ds_senha", nullable = false)
    private String dsSenha;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;
}
