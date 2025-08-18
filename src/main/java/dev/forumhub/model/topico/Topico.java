package dev.forumhub.model.topico;

import dev.forumhub.model.topico.dto.entrada.DadosTopicoAtualizacao;
import dev.forumhub.model.topico.dto.entrada.IDadosTopicoEntrada;
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

    private boolean ativo;


    public Topico(IDadosTopicoEntrada dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = dados.status();
        this.usuario = dados.usuario();
        this.curso = dados.curso();
    }

    public void atualizar(DadosTopicoAtualizacao topicoAtualizado){
        if (topicoAtualizado.titulo() != null){
            this.titulo = topicoAtualizado.titulo();
        }
        if (topicoAtualizado.mensagem() != null){
            this.mensagem = topicoAtualizado.mensagem();
        }
        if (topicoAtualizado.status() != null){
            this.status = topicoAtualizado.status();
        }
        if (topicoAtualizado.usuario() != null){
            this.usuario = topicoAtualizado.usuario();
        }
        if (topicoAtualizado.curso() != null){
            this.curso = topicoAtualizado.curso();
        }
    }
}
