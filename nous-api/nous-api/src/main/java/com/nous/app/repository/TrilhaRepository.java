package com.nous.app.repository;

import com.nous.app.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {

    boolean existsByDsTitulo(String dsTitulo);
}
