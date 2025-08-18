package dev.forumhub.service.topico.entradadedados;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoAtualizacao;
import dev.forumhub.model.topico.dto.entrada.DadosTopicoCadastro;
import dev.forumhub.model.topico.dto.entrada.IDadosTopicoEntrada;
import dev.forumhub.repository.TopicoRepository;
import dev.forumhub.service.topico.ValidadorTopico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private List<ValidadorTopico> validadores;

    @Transactional
    public Topico cadastrar(DadosTopicoCadastro dados){
        validar(dados, null);
        Topico topico = new Topico(dados);

        repository.save(topico);

        return topico;
    }

    @Transactional
    public Topico atualizar(Long id, DadosTopicoAtualizacao dados){
        validar(dados, id);

        Topico topico = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        topico.atualizar(dados);
        return topico;
    }

    private void validar(IDadosTopicoEntrada dados, Long id){
        validadores.forEach( v -> v.validar(dados, id));
    }

}
