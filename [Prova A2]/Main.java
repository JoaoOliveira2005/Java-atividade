package org.example;

import org.example.dao.PostDAO;
import org.example.dao.UsuarioDAO;
import org.example.models.Post;
import org.example.models.Usuario;
import org.example.models.Usuario.TipoUsuario;
import org.example.utils.DBConnection;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        
        DBConnection.inicializarBancoDeDados();

        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PostDAO postDAO = new PostDAO();
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Cadastrar Post");
            System.out.println("6. Atualizar Post");
            System.out.println("7. Excluir Post");
            System.out.println("8. Listar Posts por Usuário");
            System.out.println("9. Listar Todos os Usuários");
            System.out.println("10. Sair");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {

                case 1:
                    System.out.println("Digite seu email:");
                    String email = scanner.nextLine();
                    System.out.println("Digite sua senha:");
                    String senha = scanner.nextLine();
                    Usuario usuario = usuarioDAO.autenticar(email, senha);
                    if (usuario != null) {
                        System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome() + " (" + usuario.getTipoUsuario() + ")");
                    } else {
                        System.out.println("Falha no login. Verifique suas credenciais.");
                    }
                    break;

                case 2:

                    System.out.println("Digite seu email:");
                    String novoEmail = scanner.nextLine();
                    System.out.println("Digite sua senha:");
                    String novaSenha = scanner.nextLine();
                    System.out.println("Digite seu nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite seu tipo de usuário (ADMINISTRADOR, EDITOR, VISUALIZADOR):");
                    String tipoUsuarioStr = scanner.nextLine().toUpperCase();


                    TipoUsuario tipoUsuario;
                    try {
                        tipoUsuario = TipoUsuario.valueOf(tipoUsuarioStr);
                        Usuario novoUsuario = new Usuario(novoEmail, novaSenha, nome, tipoUsuario);
                        usuarioDAO.criarUsuario(novoUsuario);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Tipo de usuário inválido. Use ADMINISTRADOR, EDITOR ou VISUALIZADOR.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o email do usuário a ser atualizado:");
                    String emailAtualizar = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String senhaAtualizar = scanner.nextLine();
                    System.out.println("Digite o novo nome:");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("Digite o novo tipo de usuário (ADMINISTRADOR, EDITOR, VISUALIZADOR):");
                    String tipoUsuarioAtualizarStr = scanner.nextLine().toUpperCase();


                    TipoUsuario tipoUsuarioAtualizar;
                    try {
                        tipoUsuarioAtualizar = TipoUsuario.valueOf(tipoUsuarioAtualizarStr);
                        Usuario usuarioAtualizar = new Usuario(emailAtualizar, senhaAtualizar, nomeAtualizar, tipoUsuarioAtualizar);
                        usuarioDAO.atualizarUsuario(usuarioAtualizar);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Tipo de usuário inválido. Use ADMINISTRADOR, EDITOR ou VISUALIZADOR.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o email do usuário a ser excluído:");
                    String emailExcluir = scanner.nextLine();
                    usuarioDAO.excluirUsuario(emailExcluir);
                    break;

                case 5:
                    System.out.println("Digite o título do post:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o conteúdo do post:");
                    String conteudo = scanner.nextLine();
                    System.out.println("Digite seu email:");
                    String emailPost = scanner.nextLine();
                    Date dataPublicacao = new Date();
                    Post novoPost = new Post(titulo, conteudo, dataPublicacao, emailPost);
                    postDAO.criarPost(novoPost);
                    System.out.println("Post cadastrado com sucesso!");
                    break;

                case 6:
                    System.out.println("Digite o título do post a ser atualizado:");
                    String tituloAtualizar = scanner.nextLine();
                    System.out.println("Digite o novo conteúdo do post:");
                    String conteudoAtualizar = scanner.nextLine();
                    System.out.println("Digite seu email:");
                    String emailPostAtualizar = scanner.nextLine();
                    Post postAtualizar = new Post(tituloAtualizar, conteudoAtualizar, new Date(), emailPostAtualizar);
                    postDAO.atualizarPost(postAtualizar);
                    break;
                case 7:
                    System.out.println("Digite o título do post a ser excluído:");
                    String tituloExcluir = scanner.nextLine();
                    System.out.println("Digite seu email:");
                    String emailPostExcluir = scanner.nextLine();
                    postDAO.excluirPost(tituloExcluir, emailPostExcluir);
                    break;
                case 8:
                    System.out.println("Digite seu email:");
                    String emailParaListarPosts = scanner.nextLine();
                    List<Post> posts = postDAO.listarPostsPorUsuario(emailParaListarPosts);
                    System.out.println("Posts de " + emailParaListarPosts + ":");
                    for (Post post : posts) {
                        System.out.println("Título: " + post.getTitulo());
                        System.out.println("Conteúdo: " + post.getConteudo());
                        System.out.println("Data de Publicação: " + post.getDataPublicacao());
                        System.out.println("====================================");
                    }
                    break;
                case 9:
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    System.out.println("Usuários cadastrados:");
                    for (Usuario u : usuarios) {
                        System.out.println("Email: " + u.getEmail());
                        System.out.println("Nome: " + u.getNome());
                        System.out.println("Tipo de Usuário: " + u.getTipoUsuario());
                        System.out.println("====================================");
                    }
                    break;
                case 10:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
