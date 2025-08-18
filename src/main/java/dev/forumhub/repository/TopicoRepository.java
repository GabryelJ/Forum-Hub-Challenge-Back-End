package dev.forumhub.repository;

import dev.forumhub.model.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{
    boolean existsByMensagemAndTitulo(String mensagem, String titulo);

    boolean existsByMensagemAndTituloAndIdNot(String mensagem, String titulo, Long id);
}
