# 🧩 Projeto Web Service com Spring Boot

Este projeto foi desenvolvido durante o curso de Java Completo do [Nélio Alves](https://www.udemy.com/course/java-curso-completo/), com o objetivo de construir uma API RESTful utilizando Spring Boot, JPA/Hibernate, banco de dados H2 e outras ferramentas modernas do ecossistema Java.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (memória)
- Maven
- Postman (para testes)
- JPA / Hibernate

---

## 📁 Estrutura do Projeto

```bash
spring/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           ├── Application.java
│   │   │           ├── controllers/
│   │   │           ├── entities/
│   │   │           ├── repositories/
│   │   │           └── services/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── ...
├── pom.xml
└── README.md
```
## ▶️ Como executar o projeto
Clone o repositório:

```bash
git clone https://github.com/ErickRGuimaraes/Cursos.git
```
Acesse a pasta do projeto Spring:

```bash
cd Cursos/Java/spring
```
Importe o projeto em sua IDE (IntelliJ, Eclipse ou VS Code com Java Extension).

Rode a aplicação pela classe Application.java.

Acesse a aplicação no navegador ou via Postman:

```bash
http://localhost:8080
```
## 📌 Exemplos de Endpoints
```http
GET    /users        -> Lista todos os usuários  
GET    /users/{id}   -> Retorna um usuário específico  
POST   /users        -> Cria um novo usuário  
PUT    /users/{id}   -> Atualiza um usuário  
DELETE /users/{id}   -> Deleta um usuário
```
## 🧪 Banco de Dados H2
O projeto utiliza banco em memória H2. A interface web pode ser acessada em:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (em branco)

## 📚 Aprendizados
Durante o desenvolvimento, foram trabalhados:

RESTful API

Inversão de Controle (IoC)

Injeção de dependência (@Autowired)

Requisições HTTP com @GetMapping, @PostMapping, etc.

Entidades JPA e relacionamentos

Tratamento de exceções

Testes com Postman

## 🧑‍💻 Autor
Feito com 💻 por Erick R. Guimarães

📧 erickguimaraes88526601@email.com  
🔗 [LinkedIn](https://www.linkedin.com/in/erickrguimaraes/)  
💻 [LeetCode](https://leetcode.com/u/ErickRGuimaraes/) 
