CREATE TABLE comentario (
    id SERIAL PRIMARY KEY,
    data_hora DATETIME NOT NULL,
    mensagem TEXT NOT NULL
);