package com.nous.app.controller;

import com.nous.app.model.Trilha;
import com.nous.app.service.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    // Criar trilha
    @PostMapping
    public ResponseEntity<EntityModel<Trilha>> criar(@RequestBody Trilha trilha) {
        Trilha novaTrilha = trilhaService.criarTrilha(trilha);

        // Adiciona links HATEOAS
        EntityModel<Trilha> resource = EntityModel.of(novaTrilha);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TrilhaController.class)
                .buscarPorId(novaTrilha.getIdTrilha())).withSelfRel();
        Link allLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TrilhaController.class)
                .listarTodas()).withRel("todas-trilhas");

        resource.add(selfLink, allLink);

        return ResponseEntity
                .created(selfLink.toUri())
                .body(resource);
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<Trilha>> listarTodas() {
        return ResponseEntity.ok(trilhaService.listarTodas());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Trilha>> buscarPorId(@PathVariable Long id) {
        Trilha trilha = trilhaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        EntityModel<Trilha> resource = EntityModel.of(trilha);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TrilhaController.class)
                .listarTodas()).withRel("todas-trilhas"));

        return ResponseEntity.ok(resource);
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id, @RequestBody Trilha trilhaAtualizada) {
        Trilha atualizada = trilhaService.atualizarTrilha(id, trilhaAtualizada);
        return ResponseEntity.ok(atualizada);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trilhaService.deletarTrilha(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
