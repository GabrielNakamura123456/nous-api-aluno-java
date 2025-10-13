 NOUS API - Módulo Aluno (Java Spring Boot)
 Descrição Geral

O projeto NOUS é uma solução tecnológica voltada para o apoio emocional e educacional de jovens brasileiros.
Nesta Sprint Java Advanced, foi desenvolvido o domínio “Aluno” utilizando Spring Boot, aplicando conceitos de POO, JPA e APIs RESTful para persistir e consultar dados em um banco de dados relacional.

A aplicação segue os princípios da Clean Architecture, garantindo coesão, baixo acoplamento e fácil manutenção.

 Integrantes do Grupo
Nome	RM	Responsabilidade
Guilherme Costeira Braganholo	RM560628	Desenvolvimento do backend em Java / Estrutura Spring Boot
Julio Cesar Dias Vilella	RM560494	Modelagem de entidades e diagramas (Classe e DER)
Gabriel Nakamura Ogata	RM560671	Documentação, testes com Postman e integração com GitHub
 Objetivo da Aplicação

Fornecer um backend RESTful para o gerenciamento de alunos dentro da plataforma NOUS, permitindo:

Cadastro e consulta de alunos;

Persistência de dados no banco de dados relacional;

Organização do código com camadas de Model, Repository, Service e Controller;

Testes via Postman para validação dos endpoints.

 Tecnologias Utilizadas

Java 17

Spring Boot

Spring Data JPA

H2 Database / Oracle

Maven

Postman

GitHub
🏗️ Estrutura do Projeto
📦 nous-api-aluno-java
 ┣ 📂 src/main/java/com/nous/app
 ┃ ┣ 📂 controller
 ┃ ┣ 📂 model
 ┃ ┣ 📂 repository
 ┃ ┣ 📂 service
 ┃ ┗ 📜 NousApiAlunoApplication.java
 ┣ 📂 resources
 ┣ 📂 test
 ┗ 📜 pom.xml



🔗 Endpoints Principais
Método	Endpoint	Descrição
POST	/api/usuarios	Cria um novo aluno
GET	/api/usuarios	Lista todos os alunos
GET	/api/usuarios/{id}	Consulta aluno por ID
PUT	/api/usuarios/{id}	Atualiza dados do aluno
DELETE	/api/usuarios/{id}	Remove aluno do sistema
Testes

Os endpoints foram testados utilizando o Postman.
O arquivo de requisições exportado encontra-se na pasta:

 docs/postman_collection.json

 Como Executar o Projeto

Clonar o repositório:

git clone https://github.com/GabrielNakamura123456/nous-api-aluno-java.git


Acessar o diretório do projeto:

cd nous-api-aluno-java


Executar o projeto:

mvn spring-boot:run


Acessar no navegador:

http://localhost:8080/api/usuarios

 Vídeo de Apresentação

 Link do vídeo (YouTube - modo não listado):https://www.youtube.com/watch?v=DMCuUgNrBus
https://youtu.be/SEU-LINK-AQUI


