# 🔧 Projeto E-commerce

![Projeto E-commerce](https://github.com/user-attachments/assets/fa11e404-bf47-4b30-a4a0-d3fd206cb897)

Este projeto foi desenvolvido como parte de uma atividade acadêmica, com o objetivo de implementar uma aplicação web para um sistema de e-commerce. O projeto conta com um back-end em Spring Boot e um front-end desenvolvido com HTML, CSS e JavaScript.

---

## 🚀 Tecnologias Utilizadas

### Back-end:

- **Spring Boot 3.4.0**
- **Spring Data JPA**: Para manipulação e persistência de dados com JPA/Hibernate.
- **Spring Boot Starter Validation**: Para validação de atributos nas entidades.
- **Spring Boot DevTools**: Para facilitar o desenvolvimento com hot-reload.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Spring Boot Starter Test**: Para testes unitários e de integração.

### Front-end:

- **HTML**
- **CSS** (com o uso do framework [Bootstrap](https://getbootstrap.com/))
- **JavaScript**

---

## 🕐 Funcionalidades Implementadas

### Back-end

#### ✅ Tela de Login

- Implementada autenticação de usuários com validação de credenciais.

#### ✅ CRUD da Entidade Usuário

- Operações implementadas:
  - **Inserir**: Adicionar novos usuários ao sistema.
  - **Atualizar**: Atualizar dados cadastrais de um usuário.
  - **Deletar**: Remover usuários do sistema.
  - **Listar**: Consultar a lista de usuários cadastrados.

#### ✅ CRUD de Duas Entidades (Produtos e Pedidos)

- **Entidade Produto**:

  - Atributos: `id`, `nome`, `descricao`, `preco`, `quantidade`.
  - Validações aplicadas:
    - `nome`: Deve ser preenchido e ter no mínimo 3 caracteres.
    - `preco`: Deve ser um valor positivo.
  - Operações: Inserir, Atualizar, Deletar e Listar.

- **Entidade Pedido**:

  - Atributos: `id`, `dataPedido`, `status`, `valorTotal`, `usuario`.
  - Validações aplicadas:
    - `dataPedido`: Deve estar no formato de data válido.
    - `valorTotal`: Deve ser um valor positivo.
  - Operações: Inserir, Atualizar, Deletar e Listar.

#### 🛠️ Gerenciamento de Banco de Dados

- Todas as operações CRUD do sistema são gerenciadas pelo back-end, que realiza requisições ao banco de dados H2.

### Front-end

#### 🔒 Tela de Login

- Tela de autenticação desenvolvida com validação de campos usando JavaScript.

#### 📊 Tela de Gerenciamento

- Interfaces para operações CRUD das entidades Produto e Pedido.

---

## 🎯 Como executar o projeto

### Pré-requisitos:

- **Java 17+**: Certifique-se de que o JDK está instalado.
- **Maven**: Para gerenciar as dependências.

### Passos para executar o Back-end:

1. Clone o repositório:

   ```bash
   https://github.com/lucasbor1/prova-Java-Script.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd Api
   ```

3. Execute o comando Maven para iniciar o servidor:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse o servidor local para interagir com a API:

   ```
   http://localhost:8080
   ```

### Front-end:

1. Abra os arquivos HTML em qualquer navegador.

---

## 📸 Exemplos visuais:

<div align="center">
    <img src="https://github.com/user-attachments/assets/f2364f4e-beb9-4337-b05b-ef0f017341c5" width="30%" alt="Tela 1">
    <img src="https://github.com/user-attachments/assets/40049f3a-6c98-4a67-94f5-ac4977f4bf9c" width="30%" alt="Tela 2">
    <img src="https://github.com/user-attachments/assets/0cc4753e-fe3f-4cbb-bb11-d18dbdb8f1c2" width="30%" alt="Tela 3">
</div>

---
