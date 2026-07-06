# JTicket

Sistema web de gerenciamento de chamados técnicos desenvolvido como MVP para a disciplina **Práticas Extensionistas III** da Unoesc.

## Integrantes
- **Kévin Brayan dos Santos Teixeira** — 439888
- **Kauan Natanael de Oliveira** — 425877

**Curso:** ADS Unoesc On-line

## Tecnologias
- Java 17
- Spring Boot
- Spring Security (JWT)
- Thymeleaf
- Bootstrap 5
- MySQL
- Flyway
- Maven

## Funcionalidades
- Login de usuários
- Cadastro de usuários
- CRUD de chamados
- Pesquisa por título
- Visualização de detalhes
- Perfil do usuário
- Formulário de contato

## Requisitos da atividade
- Modelo relacional do banco de dados
- Banco funcional em MySQL
- Interface principal
- Interface de login
- CRUD de chamados
- Consulta/pesquisa
- Formulário de contato
- Código e diagramas publicados no GitHub

## GitHub
https://github.com/k3vin-exe/jticket

## Execução

Crie o banco de dados MySQL chamado com o nome jticket, conforme `application.properties`.

```SQL
CREATE DATABASE jticket;
```

Execute via terminal ou via IDE

```bash
mvn spring-boot:run
```
