# 📦 Projeto Spring Boot + MongoDB (Web Services com NoSQL)

Este projeto foi desenvolvido durante o curso de Java Completo do [Nélio Alves](https://www.udemy.com/course/java-curso-completo/),  
O objetivo foi criar uma API RESTful utilizando **Spring Boot**, persistência de dados com **MongoDB**, testes com **Postman**, e visualização de dados com o **MongoDB Compass**.

---

## 🚀 Tecnologias utilizadas

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Data MongoDB
- ✅ MongoDB (NoSQL)
- ✅ MongoDB Compass
- ✅ Postman
- ✅ Maven

---

## 📂 Estrutura de diretórios

```bash
spring-boot-mongodb/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/spring_boot_mongodb/
│ │ │ ├── config/
│ │ │ ├── domain/
│ │ │ ├── dto/
│ │ │ ├── repository/
│ │ │ ├── resources/
│ │ │ │ └── exception/
│ │ │ ├── services/
│ │ │ │ └── exception/
│ │ │ ├── Application.java
│ │ └── resources/
│ │ ├── application.properties
│ └── test/
│ └── ...
├── pom.xml
└── README.md
```
## ▶️ Como executar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/ErickRGuimaraes/Cursos.git
```
Navegue até o projeto:

```bash
cd Cursos/Java/spring-boot-mongodb
```
Importe na sua IDE favorita (IntelliJ, Eclipse, VS Code com Extensão Java).

Certifique-se de ter o MongoDB rodando localmente.

Execute a classe:

```bash
SpringBootMongodbApplication.java
```
##🌐 Acessos disponíveis
```http
API RESTful (via Postman ou browser):
GET /users → Lista todos os usuários

GET /users/{id} → Busca usuário por ID

POST /users → Cadastra um novo usuário

PUT /users/{id} → Atualiza os dados do usuário

DELETE /users/{id} → Deleta um usuário

GET /users/{id}/posts → Lista os posts do usuário
```

## Banco de Dados:
Acesso via MongoDB Compass

Database: workshop_mongo

Collections: user, post

## 📚 Conceitos abordados
Durante o desenvolvimento, foram trabalhados:

CRUD com Spring Boot e MongoDB

API RESTful com boas práticas

Padrão DTO (Data Transfer Object)

Tratamento de exceções com @ControllerAdvice

Injeção de Dependência com @Autowired

Padrão camadas: Resource → Service → Repository

Instanciação automatizada de dados com CommandLineRunner

Integração com Postman

## 🧑‍💻 Autor
Feito com 💻 por Erick R. Guimarães

📧 erickguimaraes88526601@email.com  
🔗 [LinkedIn](https://www.linkedin.com/in/erickrguimaraes/)  
💻 [LeetCode](https://leetcode.com/u/ErickRGuimaraes/) 
