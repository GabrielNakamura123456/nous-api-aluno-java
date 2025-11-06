package com.nous.app.service;

import com.nous.app.model.Trilha;
import com.nous.app.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrilhaService {

    @Autowired
    private TrilhaRepository trilhaRepository;

    public Trilha criarTrilha(Trilha trilha) {
        if (trilhaRepository.existsByDsTitulo(trilha.getDsTitulo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título já cadastrado!");
        }
        return trilhaRepository.save(trilha);
    }

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Optional<Trilha> buscarPorId(Long id) {
        return trilhaRepository.findById(id);
    }

    public Trilha atualizarTrilha(Long id, Trilha trilhaAtualizada) {
        Trilha trilhaExistente = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada"));

        trilhaExistente.setDsTitulo(trilhaAtualizada.getDsTitulo());
        trilhaExistente.setDsDescricao(trilhaAtualizada.getDsDescricao());
        trilhaExistente.setDsCategoria(trilhaAtualizada.getDsCategoria());

        return trilhaRepository.save(trilhaExistente);
    }

    public void deletarTrilha(Long id) {
        if (!trilhaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada");
        }
        trilhaRepository.deleteById(id);
    }
}
