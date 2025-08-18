package dev.forumhub.service.topico.cadastro.validadores;

import dev.forumhub.model.exceptions.ValidacaoException;
import dev.forumhub.model.topico.dto.DadosTopicoCadastro;
import dev.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidadorNomeEMensagemUnicos implements ValidadorCadastroTopico {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosTopicoCadastro dados) {
        boolean existsByMensagemAndTitulo = repository.existsByMensagemAndTitulo(dados.mensagem(), dados.titulo());
        if (existsByMensagemAndTitulo){
            throw new ValidacaoException("Já existe um tópico com estes titulo e mensagem!");
        }
    }
}
