package com.nous.app.service;

import com.nous.app.model.CheckinEmocional;
import com.nous.app.model.Usuario;
import com.nous.app.repository.CheckinEmocionalRepository;
import com.nous.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável por regras de negócio relacionadas aos check-ins emocionais.
 */
@Service
public class CheckinEmocionalService {

    @Autowired
    private CheckinEmocionalRepository checkinRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Cria um novo check-in emocional associado a um usuário.
     */
    public CheckinEmocional criarCheckin(Long idUsuario, CheckinEmocional checkin) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        // Garante que o check-in tenha data
        if (checkin.getDtCheckin() == null) {
            checkin.setDtCheckin(LocalDate.now());
        }

        checkin.setUsuario(usuarioOpt.get());
        return checkinRepository.save(checkin);
    }

    /**
     * Lista todos os check-ins cadastrados no sistema.
     */
    public List<CheckinEmocional> listarTodos() {
        return checkinRepository.findAll();
    }

    /**
     * Lista todos os check-ins de um usuário específico.
     */
    public List<CheckinEmocional> listarPorUsuario(Long idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        return checkinRepository.findByUsuarioIdUsuario(idUsuario);
    }

    /**
     * Busca um check-in emocional específico pelo ID.
     */
    public CheckinEmocional buscarPorId(Long idCheckin) {
        return checkinRepository.findById(idCheckin)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Check-in não encontrado"));
    }

    /**
     * Atualiza os dados de um check-in emocional existente.
     */
    public CheckinEmocional atualizarCheckin(Long idCheckin, CheckinEmocional checkinAtualizado) {
        CheckinEmocional existente = buscarPorId(idCheckin);

        existente.setNrHumor(checkinAtualizado.getNrHumor());
        existente.setDsComentario(checkinAtualizado.getDsComentario());
        existente.setDtCheckin(checkinAtualizado.getDtCheckin());

        return checkinRepository.save(existente);
    }

    /**
     * Exclui um check-in emocional.
     */
    public void deletarCheckin(Long idCheckin) {
        if (!checkinRepository.existsById(idCheckin)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Check-in não encontrado");
        }
        checkinRepository.deleteById(idCheckin);
    }
}
