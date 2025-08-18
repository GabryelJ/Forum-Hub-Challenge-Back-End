package dev.forumhub.model.topico;

import dev.forumhub.model.topico.dto.DadosTopicoCadastro;
import dev.forumhub.model.topico.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String usuario;

    private String curso;

    public Topico(DadosTopicoCadastro dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = dados.status();
        this.usuario = dados.usuario();
        this.curso = dados.curso();
    }
}
