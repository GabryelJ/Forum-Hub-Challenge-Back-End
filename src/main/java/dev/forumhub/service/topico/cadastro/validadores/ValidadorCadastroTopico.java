package dev.forumhub.service.topico.cadastro.validadores;

import dev.forumhub.model.topico.dto.DadosTopicoCadastro;

public interface ValidadorCadastroTopico {
    void validar(DadosTopicoCadastro dados);
}
