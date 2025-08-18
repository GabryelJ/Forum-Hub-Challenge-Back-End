package dev.forumhub.controller;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoAtualizacao;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoCadastro;
import dev.forumhub.model.topico.dto.saida.DadosTopicoDetalhamento;
import dev.forumhub.repository.TopicoRepository;
import dev.forumhub.service.topico.entradadedados.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
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
}
