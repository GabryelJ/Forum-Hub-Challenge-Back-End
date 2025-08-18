package dev.forumhub.model.topico.dto.entrada;

import dev.forumhub.model.topico.status.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopicoCadastro(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotNull Status status,
        @NotBlank String usuario,
        @NotBlank String curso) implements IDadosTopicoEntrada {
}
