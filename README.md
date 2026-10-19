# Meus Favoritos

API REST para gerenciamento de usuários e organização de coleções pessoais de jogos, filmes e músicas. O projeto utiliza Java e Spring Boot, com persistência em MySQL e autenticação baseada em JWT.

## Tecnologias

- **Java 21** — linguagem de desenvolvimento.
- **Spring Boot 4.1.1** — configuração e execução da aplicação.
- **Spring Web MVC** — criação dos endpoints REST.
- **Spring Data JPA / Hibernate** — persistência e mapeamento objeto-relacional.
- **MySQL** — banco de dados relacional.
- **Spring Security** — autenticação e controle de acesso.
- **JSON Web Token (JWT)** — autenticação stateless.
- **BCrypt** — codificação de senhas.
- **Lombok** — redução de código repetitivo.
- **Springdoc OpenAPI** — documentação interativa da API.
- **Maven** — gerenciamento de dependências e build.

## Funcionalidades

### Usuários e autenticação

- Cadastro de usuários com validação dos dados.
- Autenticação por e-mail e senha.
- Geração de tokens JWT após o login.
- Armazenamento de senhas com BCrypt.
- Controle de acesso por perfil de usuário.
- Consulta e exclusão de usuários.

### Catálogo

O sistema possui recursos para cadastrar, consultar e excluir itens das seguintes categorias:

- **Jogos**
- **Filmes**
- **Músicas**

Cada categoria possui endpoints próprios para criação, listagem e consulta por identificador. A exclusão dos itens do catálogo é restrita a usuários com permissão administrativa.

### Favoritos

Os usuários podem associar jogos, filmes e músicas ao próprio perfil. Essas associações são persistidas no banco de dados por meio de relacionamentos entre usuários e itens do catálogo.

## Arquitetura

O backend está organizado em camadas, separando o tratamento das requisições, as regras de negócio e o acesso aos dados.

```text
com.spring.meusfavoritos
├── config
│   ├── CorsConfig
│   ├── JwtAuthenticationFilter
│   ├── SecurityConfiguration
│   └── TokenProvider
├── controller
│   ├── AuthController
│   ├── GameController
│   ├── MovieController
│   ├── MusicController
│   └── UserController
├── dto
├── model
│   └── enumeration
├── repository
├── service
└── MeusFavoritosApplication
```

**Responsabilidades das camadas:**

- `controller`: recebe requisições HTTP, valida entradas e define as respostas da API.
- `service`: concentra as operações e regras de negócio.
- `repository`: utiliza Spring Data JPA para consultar e persistir entidades.
- `model`: define as entidades mapeadas no banco de dados.
- `dto`: separa os dados de entrada e saída dos modelos de persistência.
- `config`: reúne as configurações de segurança, CORS e autenticação JWT.

## Modelo de dados

A aplicação utiliza entidades JPA para representar usuários, jogos, filmes e músicas.

A entidade `UserModel` possui relacionamentos `@ManyToMany` com as entidades de jogos, filmes e músicas, utilizando tabelas associativas para armazenar os favoritos de cada usuário.

O identificador dos registros é gerado pelo banco de dados. O e-mail do usuário possui restrição de unicidade, e o perfil de acesso é representado pelo enum `Role`.

## Endpoints da API

A aplicação utiliza a porta `3000` por padrão.

### Autenticação

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/auth/register` | Cadastra um usuário |
| POST | `/auth/login` | Autentica o usuário e retorna um JWT |

### Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/users` | Cadastra um usuário |
| GET | `/users` | Lista usuários |
| GET | `/users/{id}` | Consulta um usuário por ID |
| DELETE | `/users/{id}` | Exclui um usuário |
| GET | `/users/me` | Consulta o perfil autenticado |
| POST | `/users/{userId}/favorites/games/{gameId}` | Adiciona um jogo aos favoritos |
| POST | `/users/{userId}/favorites/movies/{movieId}` | Adiciona um filme aos favoritos |
| POST | `/users/{userId}/favorites/musics/{musicId}` | Adiciona uma música aos favoritos |

### Jogos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/games` | Cadastra um jogo |
| GET | `/games` | Lista jogos |
| GET | `/games/{id}` | Consulta um jogo por ID |
| DELETE | `/games/{id}` | Exclui um jogo |

### Filmes

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/movies` | Cadastra um filme |
| GET | `/movies` | Lista filmes |
| GET | `/movies/{id}` | Consulta um filme por ID |
| DELETE | `/movies/{id}` | Exclui um filme |

### Músicas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/musics` | Cadastra uma música |
| GET | `/musics` | Lista músicas |
| GET | `/musics/{id}` | Consulta uma música por ID |
| DELETE | `/musics/{id}` | Exclui uma música |

As rotas protegidas exigem autenticação conforme as regras configuradas no Spring Security. Para as requisições autenticadas, utilize o cabeçalho:

```http
Authorization: Bearer <seu-token-jwt>
```

Os endpoints acima refletem os mapeamentos encontrados no código. O comportamento efetivo das rotas de usuários e favoritos depende da resolução dos conflitos de merge identificados no repositório.

## Como executar

### Pré-requisitos

- JDK 21.
- MySQL.
- Git.

### 1. Clone o repositório

```bash
git clone https://github.com/PedroAugustoRF/Meus-Favoritos.git
cd Meus-Favoritos/meusfavoritos
```

### 2. Configure o banco de dados

Crie um banco de dados MySQL para a aplicação:

```sql
CREATE DATABASE meus_favoritos;
```

Configure a conexão no arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=meusfavoritos
server.port=3000

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/meus_favoritos}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.expiration=${JWT_EXPIRATION:900000}
jwt.key=${JWT_KEY}
```

Defina as variáveis de ambiente `DB_PASSWORD` e `JWT_KEY` antes de executar a aplicação. A chave JWT deve ser secreta, forte e compatível com o algoritmo de assinatura utilizado.

**Importante:** o bloco acima é uma configuração recomendada para substituir a configuração atual; ele ainda precisa ser aplicado ao projeto. Não mantenha credenciais ou chaves privadas versionadas no repositório.

### 3. Execute a aplicação

Após resolver os conflitos de merge e confirmar que as dependências e a configuração estão corretas, execute a partir da pasta `meusfavoritos`:

No Windows:

```bat
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:3000
```

### 4. Acesse a documentação

Com a aplicação em execução, a documentação interativa do Springdoc OpenAPI poderá ser acessada em:

- Swagger UI: `http://localhost:3000/swagger-ui.html`
- OpenAPI JSON: `http://localhost:3000/v3/api-docs`

## Testes

A estrutura do projeto contém uma classe de testes de aplicação. A execução da suíte de testes e a validação dos endpoints devem ser realizadas após a correção dos conflitos de merge e a configuração do ambiente.

## Objetivo do projeto

O Meus Favoritos foi desenvolvido para
