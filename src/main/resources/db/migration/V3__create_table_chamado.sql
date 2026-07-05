CREATE TABLE chamado (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_abertura DATETIME NOT NULL,
    prioridade VARCHAR(50),
    status VARCHAR(50) NOT NULL DEFAULT 'ABERTO',
    categoria VARCHAR(100),
    data_fechamento DATETIME
);