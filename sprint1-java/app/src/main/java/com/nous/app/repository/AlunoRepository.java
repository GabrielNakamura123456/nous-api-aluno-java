package com.nous.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nous.app.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
