# PetStore API Automation

Projeto de automação de testes de API desenvolvido em Java utilizando Rest Assured e TestNG, com base na API pública Swagger PetStore.

## Tecnologias

- Java
- Rest Assured
- TestNG
- Gradle
- JSON

## Estrutura do projeto

```
src
 └── test
      └── java
           └── petstore
                └── Pet.java

db
 ├── pet1.json
 └── pet2.json
```

### Pet.java

Classe responsável pelos testes automatizados da API.

Os testes seguem o fluxo CRUD da entidade Pet:

- Criar um Pet (POST)
- Consultar um Pet (GET)
- Alterar um Pet (PUT)
- Excluir um Pet (DELETE)

### Pasta db

Armazena os arquivos JSON utilizados como payload durante os testes.

Separar os payloads do código facilita a manutenção e reutilização dos dados de teste.

## Funcionalidades testadas

✔ Inclusão de um novo Pet

✔ Consulta por ID

✔ Alteração dos dados

✔ Exclusão do registro

## Validações

Durante os testes são realizadas validações como:

- Status Code
- Nome
- Categoria
- Status do Pet
- Tags
- Código de retorno

## Objetivo

Este projeto foi desenvolvido com o objetivo de praticar automação de APIs utilizando Rest Assured, organização dos testes e validação de respostas HTTP.
