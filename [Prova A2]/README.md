# Projeto de Manutenção de Usuários e Posts

## Descrição do Projeto

Projeto foi desenvolvido Java, utilizando orientação a objetos com separação de responsabilidades, a API JDBC com banco de dados relacional H2, e 
tratamento de erros. 

O objetivo é criar um sistema de manutenção de usuários e posts, com funcionalidades de cadastro, visualização, edição e exclusão de dados.

 Tecnologias Utilizadas
- **Java**
- **JDBC**
- **H2 Database**

### Configuração do Banco de Dados
O banco de dados utilizado é o H2. A conexão está configurada na classe `DBConnection.java`:

### Classes e Responsabilidades
- **DBConnection.java**: Gerencia a conexão com o banco de dados H2.
- **Usuario.java**: Modelo da entidade `Usuario` com enum `TipoUsuario`.
- **Post.java**: Modelo da entidade `Post`.
- **UsuarioDAO.java**: Contém métodos para autenticar, criar, atualizar, excluir e listar usuários.
- **PostDAO.java**: Contém métodos para criar, atualizar, excluir e listar posts por usuário.
- **Main.java**: Classe principal que interage com o usuário para realizar operações de manutenção.

### Funcionalidades

#### Manutenção de Usuários
- **Cadastro de usuários com validação de dados.**
- **Autenticação de usuários.**
- **Atualização de informações dos usuários.**
- **Exclusão de usuários.**
- **Listagem de todos os usuários.**

#### Manutenção de Posts
- **Cadastro de posts associados a um usuário.**
- **Atualização de posts.**
- **Exclusão de posts.**
- **Listagem de posts por usuário.**


