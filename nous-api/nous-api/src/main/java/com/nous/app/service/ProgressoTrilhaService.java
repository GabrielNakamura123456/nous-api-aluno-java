package com.nous.app.service;

import com.nous.app.model.ProgressoTrilha;
import com.nous.app.model.Trilha;
import com.nous.app.model.Usuario;
import com.nous.app.repository.ProgressoTrilhaRepository;
import com.nous.app.repository.TrilhaRepository;
import com.nous.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pelas regras de negócio relacionadas ao progresso de trilhas.
 */
@Service
public class ProgressoTrilhaService {

    @Autowired
    private ProgressoTrilhaRepository progressoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrilhaRepository trilhaRepository;

    /**
     * Cria um novo progresso de trilha vinculado a um usuário e a uma trilha.
     */
    public ProgressoTrilha criarProgresso(Long idUsuario, Long idTrilha, ProgressoTrilha progresso) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<Trilha> trilhaOpt = trilhaRepository.findById(idTrilha);

        if (usuarioOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        if (trilhaOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada.");
        }

        // Se não informar data de início, define como hoje
        if (progresso.getDtInicio() == null) {
            progresso.setDtInicio(LocalDate.now());
        }

        progresso.setUsuario(usuarioOpt.get());
        progresso.setTrilha(trilhaOpt.get());

        return progressoRepository.save(progresso);
    }

    /**
     * Lista todos os progressos de trilhas no sistema.
     */
    public List<ProgressoTrilha> listarTodos() {
        return progressoRepository.findAll();
    }

    /**
     * Lista progressos por usuário.
     */
    public List<ProgressoTrilha> listarPorUsuario(Long idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }
        return progressoRepository.findByUsuarioIdUsuario(idUsuario);
    }

    /**
     * Lista progressos por trilha.
     */
    public List<ProgressoTrilha> listarPorTrilha(Long idTrilha) {
        if (!trilhaRepository.existsById(idTrilha)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada.");
        }
        return progressoRepository.findByTrilhaIdTrilha(idTrilha);
    }

    /**
     * Busca um progresso específico pelo ID.
     */
    public ProgressoTrilha buscarPorId(Long id) {
        return progressoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Progresso não encontrado."));
    }

    /**
     * Atualiza o status e datas de um progresso.
     */
    public ProgressoTrilha atualizarProgresso(Long id, ProgressoTrilha progressoAtualizado) {
        ProgressoTrilha existente = buscarPorId(id);

        existente.setStTrilha(progressoAtualizado.getStTrilha());
        existente.setDtInicio(progressoAtualizado.getDtInicio());
        existente.setDtConclusao(progressoAtualizado.getDtConclusao());

        return progressoRepository.save(existente);
    }

    /**
     * Exclui um progresso de trilha.
     */
    public void deletarProgresso(Long id) {
        if (!progressoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progresso não encontrado.");
        }
        progressoRepository.deleteById(id);
    }
}
