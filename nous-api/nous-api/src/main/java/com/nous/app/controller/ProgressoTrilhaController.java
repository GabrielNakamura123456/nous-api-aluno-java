package com.nous.app.controller;

import com.nous.app.model.ProgressoTrilha;
import com.nous.app.service.ProgressoTrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints de ProgressoTrilha.
 * Implementa o nível 3 de maturidade REST (HATEOAS).
 */
@RestController
@RequestMapping("/api/progressos")
public class ProgressoTrilhaController {

    @Autowired
    private ProgressoTrilhaService progressoService;

    /**
     * Cria um novo progresso vinculado a um usuário e uma trilha.
     */
    @PostMapping("/usuario/{idUsuario}/trilha/{idTrilha}")
    public ResponseEntity<EntityModel<ProgressoTrilha>> criarProgresso(
            @PathVariable Long idUsuario,
            @PathVariable Long idTrilha,
            @RequestBody ProgressoTrilha progresso) {

        ProgressoTrilha novoProgresso = progressoService.criarProgresso(idUsuario, idTrilha, progresso);

        EntityModel<ProgressoTrilha> resource = EntityModel.of(novoProgresso);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProgressoTrilhaController.class)
                .buscarPorId(novoProgresso.getIdProgresso())).withSelfRel();
        Link allLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProgressoTrilhaController.class)
                .listarTodos()).withRel("todos-progressos");

        resource.add(selfLink, allLink);

        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    /**
     * Lista todos os progressos cadastrados.
     */
    @GetMapping
    public ResponseEntity<List<ProgressoTrilha>> listarTodos() {
        return ResponseEntity.ok(progressoService.listarTodos());
    }

    /**
     * Lista progressos de um usuário.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ProgressoTrilha>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(progressoService.listarPorUsuario(idUsuario));
    }

    /**
     * Lista progressos de uma trilha.
     */
    @GetMapping("/trilha/{idTrilha}")
    public ResponseEntity<List<ProgressoTrilha>> listarPorTrilha(@PathVariable Long idTrilha) {
        return ResponseEntity.ok(progressoService.listarPorTrilha(idTrilha));
    }

    /**
     * Busca um progresso específico.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProgressoTrilha>> buscarPorId(@PathVariable Long id) {
        ProgressoTrilha progresso = progressoService.buscarPorId(id);

        EntityModel<ProgressoTrilha> resource = EntityModel.of(progresso);
        Link allLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProgressoTrilhaController.class)
                .listarTodos()).withRel("todos-progressos");

        resource.add(allLink);

        return ResponseEntity.ok(resource);
    }

    /**
     * Atualiza o status ou as datas de um progresso existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProgressoTrilha> atualizarProgresso(
            @PathVariable Long id,
            @RequestBody ProgressoTrilha progressoAtualizado) {
        return ResponseEntity.ok(progressoService.atualizarProgresso(id, progressoAtualizado));
    }

    /**
     * Deleta um progresso de trilha.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProgresso(@PathVariable Long id) {
        progressoService.deletarProgresso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
