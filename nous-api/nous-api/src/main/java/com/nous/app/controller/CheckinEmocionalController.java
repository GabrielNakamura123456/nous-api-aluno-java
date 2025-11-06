package com.nous.app.controller;

import com.nous.app.model.CheckinEmocional;
import com.nous.app.service.CheckinEmocionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por gerenciar os endpoints de Check-ins Emocionais.
 * Implementa o nível 3 de maturidade REST com HATEOAS.
 */
@RestController
@RequestMapping("/api/checkins")
public class CheckinEmocionalController {

    @Autowired
    private CheckinEmocionalService checkinService;

    /**
     * Cria um novo check-in emocional vinculado a um usuário.
     */
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<EntityModel<CheckinEmocional>> criarCheckin(
            @PathVariable Long idUsuario,
            @RequestBody CheckinEmocional checkin) {

        CheckinEmocional novoCheckin = checkinService.criarCheckin(idUsuario, checkin);

        EntityModel<CheckinEmocional> resource = EntityModel.of(novoCheckin);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CheckinEmocionalController.class)
                .buscarPorId(novoCheckin.getIdCheckin())).withSelfRel();
        Link allLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CheckinEmocionalController.class)
                .listarTodos()).withRel("todos-checkins");

        resource.add(selfLink, allLink);

        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    /**
     * Lista todos os check-ins cadastrados.
     */
    @GetMapping
    public ResponseEntity<List<CheckinEmocional>> listarTodos() {
        return ResponseEntity.ok(checkinService.listarTodos());
    }

    /**
     * Lista os check-ins de um usuário específico.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CheckinEmocional>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(checkinService.listarPorUsuario(idUsuario));
    }

    /**
     * Busca um check-in emocional pelo ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CheckinEmocional>> buscarPorId(@PathVariable Long id) {
        CheckinEmocional checkin = checkinService.buscarPorId(id);

        EntityModel<CheckinEmocional> resource = EntityModel.of(checkin);
        Link allLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CheckinEmocionalController.class)
                .listarTodos()).withRel("todos-checkins");

        resource.add(allLink);

        return ResponseEntity.ok(resource);
    }

    /**
     * Atualiza um check-in emocional existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CheckinEmocional> atualizarCheckin(
            @PathVariable Long id,
            @RequestBody CheckinEmocional checkinAtualizado) {
        return ResponseEntity.ok(checkinService.atualizarCheckin(id, checkinAtualizado));
    }

    /**
     * Exclui um check-in emocional.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCheckin(@PathVariable Long id) {
        checkinService.deletarCheckin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
