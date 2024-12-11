package org.example.dao;

import org.example.models.Post;

import org.example.utils.DBConnection
    
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

public class PostDAO {

    public void criarPost(Post post) {
        String sql = "INSERT INTO Post (titulo, conteudo, dataPublicacao, usuarioEmail) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, post.getTitulo());
            stmt.setString(2, post.getConteudo());
            stmt.setDate(3, new java.sql.Date(post.getDataPublicacao().getTime()));
            stmt.setString(4, post.getUsuarioEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    public void atualizarPost(Post post) {
        String sql = "UPDATE Post SET conteudo = ?, dataPublicacao = ? WHERE titulo = ? AND usuarioEmail = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, post.getConteudo());
            stmt.setDate(2, new java.sql.Date(post.getDataPublicacao().getTime()));
            stmt.setString(3, post.getTitulo());
            stmt.setString(4, post.getUsuarioEmail());
            stmt.executeUpdate();
            System.out.println("Post atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    
    public void excluirPost(String titulo, String usuarioEmail) {
        String sql = "DELETE FROM Post WHERE titulo = ? AND usuarioEmail = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, usuarioEmail);
            stmt.executeUpdate();
            System.out.println("Post excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    public List<Post> listarPostsPorUsuario(String usuarioEmail) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM Post WHERE usuarioEmail = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuarioEmail);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post(rs.getString("titulo"), rs.getString("conteudo"),
                        rs.getDate("dataPublicacao"), rs.getString("usuarioEmail"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;

    }


    
}
