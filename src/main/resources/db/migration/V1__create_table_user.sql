CREATE TABLE users(
    id serial primary key,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    cargo varchar(150),
    telefone varchar(15),
    tipo_usuario varchar(50)
);