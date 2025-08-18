package dev.forumhub.service.topico.cadastro;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.dto.DadosTopicoCadastro;
import dev.forumhub.model.topico.dto.DadosTopicoDetalhamento;
import dev.forumhub.repository.TopicoRepository;
import dev.forumhub.service.topico.cadastro.validadores.ValidadorCadastroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private List<ValidadorCadastroTopico> validadores;

    public Topico cadastrar(DadosTopicoCadastro dados){

        validadores.forEach( v -> v.validar(dados));

        Topico topico = new Topico(dados);

        repository.save(topico);

        return topico;
    }
}
