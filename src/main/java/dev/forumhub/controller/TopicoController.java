package dev.forumhub.controller;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoAtualizacao;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoCadastro;
import dev.forumhub.model.topico.dto.saida.DadosTopicoDetalhamento;
import dev.forumhub.repository.TopicoRepository;
import dev.forumhub.service.topico.entradadedados.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    TopicoService service;

    @Autowired
    TopicoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopicoCadastro dados, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = service.cadastrar(dados);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosTopicoDetalhamento>> listar(@PageableDefault(size=10, sort = {"dataCriacao"}) Pageable pageable){
        var page = repository.findAll(pageable).map(DadosTopicoDetalhamento::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosTopicoDetalhamento> detalhar(@PathVariable("id") Long id) {
        Topico topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosTopicoDetalhamento(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosTopicoDetalhamento> atualizar(@PathVariable("id") Long id, @RequestBody @Valid DadosTopicoAtualizacao dados) {
        Topico topico = service.atualizar(id, dados);

        return ResponseEntity.ok(new DadosTopicoDetalhamento(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        if (topico.isPresent()){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Não existe tópico com este id.");
        }
        return ResponseEntity.noContent().build();
    }
}
