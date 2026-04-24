# CRM System - Checkpoint 5

Este projeto é um sistema de Gestão de Relacionamento com o Cliente (CRM) desenvolvido para a disciplina de **Domain-Driven Design with Java**.

## Integrantes do Grupo
Nome: Gabriel Couto Ribeiro - RM559579
Nome: Gabriel Kato Peres - RM560000
Nome: João Vitor de Matos Araujo - RM559246
Nome: Marcelo Affonso Fonseca - RM559790

## Objetivo
O objetivo deste Checkpoint 5 é conectar o domínio do sistema com um banco de dados relacional, garantindo que todas as entidades possuam suas respectivas tabelas e suporte completo a operações de CRUD.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3.2.5**
- **Spring Data JPA** (Persistência)
- **H2 Database** (Banco de dados em memória para desenvolvimento)
- **Lombok** (Produtividade)
- **Maven** (Gerenciamento de dependências)

## Estrutura do Projeto
O projeto segue os princípios de DDD e a arquitetura padrão do Spring Boot:
- `com.fiap.crm.model.entities`: Entidades JPA mapeadas para o banco de dados.
- `com.fiap.crm.model.vo`: Value Objects (ex: Endereço).
- `com.fiap.crm.model.enums`: Enumerações (Qualificação, Tipo, Área de Interesse, Status).
- `com.fiap.crm.repository`: Interfaces Spring Data JPA para persistência.
- `com.fiap.crm.service`: Lógica de negócio e orquestração de serviços.
- `com.fiap.crm.config`: Configurações e inicialização de dados.

## Como Executar
1. Importe o projeto no **IntelliJ IDEA** como um projeto Maven.
2. Execute a classe `CrmApplication`.
3. O sistema irá inicializar o banco de dados e executar uma demonstração automática de CRUD no console.
4. O console do H2 pode ser acessado em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:crmdb`).

## Requisitos Atendidos
- [x] Conexão com banco de dados via JDBC/JPA.
- [x] Tabelas individuais para todas as entidades: Vendedor, Atendente, Prospectante, Cliente, Usuário e Contrato.
- [x] Operações de CRUD implementadas para todas as entidades.
- [x] Implementação de canais de acesso e lógica de chatbot.
