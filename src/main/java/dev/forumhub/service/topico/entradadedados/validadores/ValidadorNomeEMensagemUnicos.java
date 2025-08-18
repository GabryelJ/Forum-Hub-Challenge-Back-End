package dev.forumhub.service.topico.entradadedados.validadores;

import dev.forumhub.model.exceptions.ValidacaoException;
import dev.forumhub.model.topico.dto.entrada.IDadosTopicoEntrada;
import dev.forumhub.repository.TopicoRepository;
import dev.forumhub.service.topico.ValidadorTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidadorNomeEMensagemUnicos implements ValidadorTopico {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(IDadosTopicoEntrada dados, Long id) {
        boolean existe;
        if (id == null){
            existe = repository.existsByMensagemAndTitulo(dados.mensagem(), dados.titulo());
        }else{
            existe = repository.existsByMensagemAndTituloAndIdNot(dados.mensagem(), dados.titulo(), id);
        }

        if (existe){
            throw new ValidacaoException("Já existe um tópico com estes titulo e mensagem!");
        }
    }
}
