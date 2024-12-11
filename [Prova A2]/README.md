# Projeto de Manutenção de Usuários e Posts

Descrição do Projeto
Este projeto foi desenvolvido em Java, utilizando orientação a objetos com separação de responsabilidades, a API JDBC com banco de dados relacional H2, e 
tratamento de erros conforme especificado. 
O objetivo é criar um sistema de manutenção de usuários e posts, com funcionalidades de cadastro, visualização, edição e exclusão de dados.

 Tecnologias Utilizadas
- **Java**
- **JDBC**
- **H2 Database**

### Configuração do Banco de Dados
O banco de dados utilizado é o H2. A conexão está configurada na classe `DBConnection.java`:

```java
private static final String URL = "jdbc:h2:~/test";
private static final String USER = "sa";
private static final String PASSWORD = "";

Classes e Responsabilidades
DBConnection.java: Gerencia a conexão com o banco de dados H2.

Usuario.java: Modelo da entidade Usuario com enum TipoUsuario.

Post.java: Modelo da entidade Post.

UsuarioDAO.java: Contém métodos para autenticar, criar, atualizar, excluir e listar usuários.

PostDAO.java: Contém métodos para criar, atualizar, excluir e listar posts por usuário.

Main.java: Classe principal que interage com o usuário para realizar operações de manutenção.

Funcionalidades
Manutenção de Usuários
Cadastro de usuários com validação de dados.

Autenticação de usuários.

Atualização de informações dos usuários.

Exclusão de usuários.

Listagem de todos os usuários.

Manutenção de Posts
Cadastro de posts associados a um usuário.

Atualização de posts.

Exclusão de posts.

Listagem de posts por usuário.

Tratamento de Erros
Validação de entradas do usuário.

Tratamento de exceções para garantir que o programa continue executando mesmo em caso de erros.

Execução da Aplicação
A aplicação é executada em linha de comando, utilizando System.out.print e Scanner para interação com o usuário.

Para rodar a aplicação:

Compile todos os arquivos.

Execute a classe Main.java:

Clique com o botão direito na classe Main.java e selecione Run 'Main.main()'.

Considerações Finais
Este projeto atende à especificação fornecida para a prova, garantindo a aderência aos requisitos e funcionalidades propostas. A escolha da linha de comando para interação com o usuário proporciona uma interface simples e direta para testar todas as operações.

Se precisar de mais detalhes ou tiver dúvidas, estou à disposição para ajudar! 😊