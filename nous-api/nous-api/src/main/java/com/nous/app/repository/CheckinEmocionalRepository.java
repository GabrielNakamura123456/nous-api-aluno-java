package com.nous.app.repository;

import com.nous.app.model.CheckinEmocional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckinEmocionalRepository extends JpaRepository<CheckinEmocional, Long> {

    // Busca todos os check-ins de um usuário específico
    List<CheckinEmocional> findByUsuarioIdUsuario(Long idUsuario);
}
