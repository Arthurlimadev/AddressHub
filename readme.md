# 🏠 AddressHub

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?logo=springboot)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

> API RESTful para gerenciamento de endereços de clientes com integração ViaCEP.

---

## ✨ Funcionalidades

- ✅ Cadastro de clientes com múltiplos endereços
- ✅ Busca de endereço automático via CEP (utilizando [ViaCEP](https://viacep.com.br/))
- ✅ Atualização e remoção de endereços
- ✅ Estrutura com boas práticas (DTOs, Services, Repositories)
- 🔄 Integração com API externa via OpenFeign
- 📄 Documentação Swagger
- 🧪 (Em breve) Testes unitários e de integração
- 🐳 (Em breve) Dockerfile para execução com container
- 🔐 (Em breve) Autenticação e autorização JWT

---

## 🧪 Exemplos de uso da API

### 🔹 Criar cliente

**POST** `/clientes`

```json
{
  "nome": "João da Silva",
  "cpf": "12345678900",
  "enderecos": [
    {
      "cep": "01001-000",
      "numero": "123"
    }
  ]
}
```

### 🔹 Resposta

```json
{
  "id": 1,
  "nome": "João da Silva",
  "cpf": "12345678900",
  "enderecos": [
    {
      "id": 1,
      "logradouro": "Praça da Sé",
      "bairro": "Sé",
      "cidade": "São Paulo",
      "estado": "SP",
      "cep": "01001-000",
      "numero": "123"
    }
  ]
}
```

---

## 🧰 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (Em breve Postgres)
- OpenFeign (ViaCEP)
- Swagger/OpenAPI
- Docker (em breve)

---

## 📦 Como executar localmente

### Pré-requisitos

- Java 21+
- Maven

### Clone e rode o projeto

```bash
git clone https://github.com/Arthurlimadev/AddressHub.git
cd AddressHub
./mvnw spring-boot:run
```

> A API estará disponível em: `http://localhost:8080`

### Banco de dados H2

- URL: `http://localhost:8080/h2-console`
- JDBC: `jdbc:h2:mem:addresshubdb`
- Usuário: `sa`
- Senha: *(em branco)*

---

## 📬 Testando com Postman

Você pode importar o arquivo de collection Postman que será adicionado futuramente (ex: `postman/AddressHub.postman_collection.json`) ou testar manualmente os seguintes endpoints:

| Método | Endpoint | Descrição                  |
|--------|----------|----------------------------|
| GET    | /clientes        | Lista todos os clientes      |
| GET    | /clientes/{id}   | Busca cliente por ID         |
| POST   | /clientes        | Cria um novo cliente         |
| PUT    | /clientes/{id}   | Atualiza dados do cliente    |
| DELETE | /clientes/{id}   | Remove cliente do sistema    |

---

## 🗂️ Estrutura de diretórios

```
src/
├── controller/
├── doc/
├── service/
├── repository/
├── model/
└── ...
```

---

## 📌 Status de desenvolvimento

| Funcionalidade                       | Status        |
|-------------------------------------|---------------|
| CRUD de clientes                    | ✅ Concluído  |
| Integração com ViaCEP               | ✅ Concluído  |
| Swagger/OpenAPI                     | ✅ Concluído |
| Autenticação com JWT                | 🔄 Em andamento  |
| Dockerfile + Docker Compose         | 🔜 Próximo passo |
| Deploy (Render / Railway / AWS)    | 🔜 Planejado  |

---

## 🚀 Roadmap futuro

- [ ] Integração com PostgreSQL
- [ ] Testes com JUnit + Mockito
- [ ] Deploy contínuo com GitHub Actions
- [ ] Interface Web com React (administração)

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues ou enviar PRs com melhorias, correções ou novas ideias!

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📧 Contato

Desenvolvido por **Arthur Lima**  
[GitHub](https://github.com/Arthurlimadev)