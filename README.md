# ForumHub API

Este projeto é uma **API RESTful** desenvolvida para o desafio **`Forum-Hub`** da Alura e Oracle ONE. O objetivo é simular o backend de um fórum online, permitindo a criação, gestão e interação de tópicos, com um sistema de autenticação robusto via **Token JWT**.

-----

### Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias e frameworks:

- **Java 17**
- **Spring Boot 3**: O framework principal para o desenvolvimento da API.
- **Spring Security**: Para a segurança da API, incluindo autenticação e controle de acesso.
- **Spring Data JPA**: Para a persistência de dados e interação com o banco de dados.
- **Flyway**: Para o gerenciamento de migrações do banco de dados de forma automatizada.
- **JSON Web Tokens (JWT)**: Para a autenticação de usuários e a proteção de rotas.
- **MySQL**: O banco de dados relacional utilizado para armazenar os dados.
- **Springdoc OpenAPI**: Para a geração automática da documentação da API, acessível via Swagger UI.
- **Lombok**: Para a redução da verbosidade do código Java.

-----

### Funcionalidades da API

A API oferece os seguintes recursos:

- **Autenticação de Usuários**: Login com credenciais e geração de token JWT.
- **Criação de Tópicos**: Registro de novos tópicos no fórum.
- **Listagem de Tópicos**: Consulta paginada e detalhada de todos os tópicos.
- **Atualização de Tópicos**: Modificação de informações de um tópico existente.
- **Deleção de Tópicos**: Deleção de um tópico indesejado.
- **Autenticação Segura**: A API autentica usuários verificando se a senha fornecida corresponde ao hash BCrypt armazenado no banco de dados, garantindo a integridade e a segurança das credenciais.
- **Hash BCrypt**: A segurança das senhas é garantida pelo uso do algoritmo BCrypt para a validação de senhas, protegendo contra ataques de força bruta.

-----

### Endpoints da API

A documentação interativa completa da API está disponível no [Swagger UI](https://www.google.com/search?q=http://localhost:8080/swagger-ui.html) após a inicialização do projeto.

| Método HTTP | URL | Descrição                                                         |
| :--- | :--- |:------------------------------------------------------------------|
| `POST` | `/login` | Autentica um usuário e retorna um token JWT.                      |
| `POST` | `/topicos` | Cria um novo tópico. Requer autenticação.                         |
| `GET` | `/topicos` | Lista todos os tópicos com paginação. Requer autenticação.        |
| `GET` | `/topicos/{id}` | Retorna os detalhes de um tópico específico. Requer autenticação. |
| `PUT` | `/topicos/{id}` | Atualiza um tópico existente. Requer autenticação.                |
| `DELETE` | `/topicos/{id}` | Deleta um tópico. Requer autenticação.                            |

**Exemplo de requisição para `POST /login`:**

```json
{
  "login" : "teste@email.com",
  "senha" : "123456"
}
```

**Exemplo de requisição para `POST /topicos`:**

```json
{
    "titulo": "Dúvida sobre Spring Security",
    "mensagem": "Como configurar o filtro de segurança?",
    "status": "ABERTO",
    "autor": "Gabryel",
    "curso": "Programação"
}
```

-----

### Como Rodar o Projeto

#### Pré-requisitos

- **Java 17** ou superior.
- **Maven**.
- Uma instância do **MySQL** para o banco de dados.

#### Passo a passo

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/GabryelJ/Forum-Hub-Challenge-Back-End
    cd Forum-Hub-Challenge-Back-End
    ```

2.  **Configure o banco de dados:**

    - Crie um banco de dados MySQL chamado `forumhub`.
    - Adicione as variáveis de ambiente com suas credenciais do banco de dados e a sua chave secreta para o JWT.
      - (`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `JWT_SECRET`).

3.  **Execute a aplicação:**

    - Use o Maven para rodar o projeto:

    <!-- end list -->

    ```bash
    mvn spring-boot:run
    ```

    - O Spring Boot iniciará a aplicação na porta padrão `8080`.

4.  **Acesse a documentação:**

    - Abra seu navegador e acesse a URL para visualizar o Swagger UI:

    <!-- end list -->

    ```
    http://localhost:8080/swagger-ui.html
    ```