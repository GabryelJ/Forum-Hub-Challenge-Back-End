package dev.forumhub.model.topico.dto.entrada;

import dev.forumhub.model.topico.status.Status;

public interface IDadosTopicoEntrada {
    String titulo();
    String mensagem();
    Status status();
    String usuario();
    String curso();
}
