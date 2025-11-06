package com.nous.app.repository;

import com.nous.app.model.ProgressoTrilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressoTrilhaRepository extends JpaRepository<ProgressoTrilha, Long> {

    // Retorna os progressos de um usuário específico
    List<ProgressoTrilha> findByUsuarioIdUsuario(Long idUsuario);

    // Retorna os progressos de uma trilha específica
    List<ProgressoTrilha> findByTrilhaIdTrilha(Long idTrilha);
}
