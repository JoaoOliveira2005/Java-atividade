package org.example.dao;

import org.example.models.Usuario;

import org.example.models.Usuario.TipoUsuario;

import org.example.utils.DBConnection;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

public class UsuarioDAO {

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        TipoUsuario.valueOf(rs.getString("tipoUsuario"))
                );
            }


            

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Tipo de usuário inválido encontrado no banco de dados.");
        }
        return null;
    }

    public void criarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, nome, tipoUsuario) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getTipoUsuario().name());
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");

        } catch (SQLException e) {
            if (e.getErrorCode() == 23505) {
                System.out.println("Erro: E-mail já cadastrado. Tente usar outro e-mail.");
            } else {
                e.printStackTrace();
            }
        }
    }



    

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET senha = ?, nome = ?, tipoUsuario = ? WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getTipoUsuario().name());
            stmt.setString(4, usuario.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuario(String email) {
        String sql = "DELETE FROM Usuario WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.executeUpdate();
            System.out.println("Usuário excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                try {
                    Usuario usuario = new Usuario(
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getString("nome"),
                            TipoUsuario.valueOf(rs.getString("tipoUsuario"))
                    );
                    usuarios.add(usuario);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: Tipo de usuário inválido encontrado para o e-mail: " + rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }




    
}
