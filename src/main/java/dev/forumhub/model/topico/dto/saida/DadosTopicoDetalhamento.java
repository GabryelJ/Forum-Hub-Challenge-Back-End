package dev.forumhub.model.topico.dto.saida;

import dev.forumhub.model.topico.Topico;
import dev.forumhub.model.topico.status.Status;

import java.time.LocalDateTime;

public record DadosTopicoDetalhamento(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Status status,
        String usuario,
        String curso) {

    public DadosTopicoDetalhamento(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getUsuario(),
                topico.getCurso()
        );
    }
}
