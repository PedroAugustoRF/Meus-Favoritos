# ❤️ Meus Favoritos

Sistema web para gerenciar **usuários** e seus **jogos, filmes e músicas favoritos**.
API REST em **Java + Spring Boot** com **MySQL** e uma interface moderna em **React + Tailwind CSS**, servida direto pelo Spring (sem build, sem Node).

## ✨ Funcionalidades

- 🔐 **Login simples**: valida e-mail e senha usando `GET /users` e guarda a sessão no `localStorage`
- 👤 **Usuários**: cadastro, listagem, exclusão e perfil individual
- 🎮🎬🎵 **Catálogo geral**: cadastro e listagem de jogos, filmes e músicas
- ❤️ **Favoritos**: vincule qualquer item do catálogo ao perfil de um usuário
- 🔎 **Detecção automática da API**: a interface procura o backend na mesma origem, em `:8080` e em `:3000`

## 🧰 Tecnologias

| Camada | Tecnologia |
|---|---|
| Backend | Java, Spring Boot, Spring Data JPA, Lombok |
| Banco | MySQL 8 |
| Frontend | React 18, Tailwind CSS, componentes no estilo shadcn/ui (via CDN) |

## 🚀 Como rodar

### 1. Banco de dados
```bash
mysql -u root -p -e "CREATE DATABASE teste;"
mysql -u root -p teste < favs.sql
```

### 2. Backend
Configure o `application.properties` com seus dados do MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/teste
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```
Depois rode a aplicação (`TestesApplication`) ou use:
```bash
./mvnw spring-boot:run
```

### 3. Frontend
Coloque o `index.html` em `src/main/resources/static/` e acesse:

```
http://localhost:8080
```

> Se abrir o HTML de outra origem (outra porta ou arquivo local), mantenha a classe `CorsConfig` em `com.spring.testes.config` para liberar o CORS.

Na primeira vez, clique em **"Cadastre-se"** na tela de login para criar o primeiro usuário.

## 🔌 Endpoints

| Recurso | Método | Rota |
|---|---|---|
| Usuários | `GET` / `POST` | `/users` |
| | `GET` / `DELETE` | `/users/{id}` |
| Jogos | `GET` / `POST` | `/games` |
| Filmes | `GET` / `POST` | `/movies` |
| Músicas | `GET` / `POST` | `/musics` |
| Favoritar jogo | `POST` | `/users/{userId}/favorites/games/{gameId}` |
| Favoritar filme | `POST` | `/users/{userId}/favorites/movies/{movieId}` |
| Favoritar música | `POST` | `/users/{userId}/favorites/musics/{musicId}` |

**Campos por recurso**

- Jogo: `name`, `publisher`, `developer`, `year`
- Filme: `name`, `studio`, `director`, `year`
- Música: `name`, `trackNumber`, `artist`, `album`, `publisher`, `year`
- Usuário: `nome`, `idade`, `aniversario`, `email`, `password`, `role` (`USER` ou `ADM`)

## 🗂️ Estrutura

```
src/main
├── java/com/spring/testes
│   ├── config        # CORS
│   ├── controller    # endpoints REST
│   ├── dto           # respostas (GameResponse, MovieResponse, MusicResponse)
│   ├── model         # entidades JPA + enum Role
│   ├── repository    # Spring Data JPA
│   └── service       # regras de negócio
└── resources/static
    └── index.html    # interface React
```

## 🗄️ Modelo de dados

`users` se relaciona **N:N** com `games`, `movies` e `musics` pelas tabelas
`user_favorite_games`, `user_favorite_movies` e `user_favorite_musics`
(com `ON DELETE CASCADE`).

## ⚠️ Aviso de segurança

Este projeto é **didático**. A senha é salva e comparada em texto puro, e o login é validado no navegador.
Para produção, use hash de senha (BCrypt), autenticação no backend (Spring Security + JWT) e não exponha a senha em `GET /users`.

## 🛣️ Próximos passos

- [ ] Remover favoritos (`DELETE`)
- [ ] Editar usuários e itens do catálogo
- [ ] Autenticação com Spring Security + JWT
- [ ] Hash de senhas com BCrypt
- [ ] Busca e filtros no catálogo

## 📄 Licença

Distribuído sob a licença MIT.
