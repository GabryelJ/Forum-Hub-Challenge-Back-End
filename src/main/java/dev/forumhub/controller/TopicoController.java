package dev.forumhub.controller;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.dto.DadosTopicoCadastro;
import dev.forumhub.service.topico.cadastro.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopicoCadastro dados, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = service.cadastrar(dados);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
