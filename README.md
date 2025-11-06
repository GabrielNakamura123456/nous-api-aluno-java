Projeto NOUS – API do Aluno (Sprint 2 - Java Advanced)
Descrição

Este projeto foi desenvolvido na disciplina Java Advanced (Sprint 2) e tem como objetivo mostrar a evolução da API do Aluno – Projeto NOUS, criada com Java e Spring Boot.
A aplicação está conectada ao banco Oracle da FIAP e permite o cadastro, atualização, listagem e exclusão de usuários e trilhas.

Nesta Sprint, o grupo:

Melhorou a estrutura do código e o uso de boas práticas (camadas Model, Repository, Service e Controller);

Adicionou o módulo Trilhas;

Implementou HATEOAS, atingindo o nível 3 de maturidade REST.

Integrantes
Nome	RM	Função
Julio César Dias Vilella	RM560494	Desenvolvimento da API e integração com o banco Oracle
Guilherme Costeira Braganholo	RM560628	Implementação dos endpoints e do HATEOAS
Gabriel Nakamura Ogata	RM560671	Modelagem das entidades e testes no Postman
Como rodar
Pré-requisitos

Java 17

Maven 3+

Banco de dados Oracle da FIAP

Conexão:

Host: oracle.fiap.com.br  
Porta: 1521  
Service Name: ORCL  
Usuário: rm560494  
Senha: 180606

Passos

Abrir o projeto no IntelliJ IDEA ou VS Code

Executar o comando:

mvn spring-boot:run


Acessar no navegador:

http://localhost:8080/swagger-ui/index.html

Endpoints principais
Usuários

POST /api/usuarios → Cria um usuário

GET /api/usuarios → Lista todos

GET /api/usuarios/{id} → Busca por ID

PUT /api/usuarios/{id} → Atualiza um usuário

DELETE /api/usuarios/{id} → Exclui um usuário

Trilhas

POST /api/trilhas → Cria uma trilha

GET /api/trilhas → Lista todas

GET /api/trilhas/{id} → Busca por ID

PUT /api/trilhas/{id} → Atualiza uma trilha

DELETE /api/trilhas/{id} → Exclui uma trilha

Testes

Todos os endpoints foram testados com sucesso no Postman, e as requisições estão disponíveis no arquivo:

sprint.postman_collection.json


Os testes confirmam que:

Os dados são salvos e consultados no Oracle corretamente;

As respostas seguem o padrão REST e incluem links HATEOAS;

Todos os CRUDs funcionam.

Cronograma
Etapa	Atividade	Responsável	Status
Semana 1	Definição da arquitetura e criação das entidades	Julio	Concluído
Semana 2	Implementação dos endpoints de Usuário	Guilherme	Concluído
Semana 3	Implementação dos endpoints de Trilha	Nakamura	Concluído
Semana 4	Testes e documentação final	Todo o grupo	Concluído
Vídeo de Apresentação
