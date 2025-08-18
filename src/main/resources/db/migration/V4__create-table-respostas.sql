CREATE TABLE respostas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(100) NOT NULL,
    topico_id BIGINT NOT NULL,
    data_criacao DATETIME NOT NULL,
    usuario_id BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL DEFAULT 0,

    PRIMARY KEY (id),
    CONSTRAINT fk_respostas_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_respostas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id)
);