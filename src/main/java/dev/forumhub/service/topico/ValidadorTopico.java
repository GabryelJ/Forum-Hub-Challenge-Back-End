package dev.forumhub.service.topico;

import dev.forumhub.model.topico.dto.entrada.IDadosTopicoEntrada;

public interface ValidadorTopico {
    void validar(IDadosTopicoEntrada dados, Long id);
}
