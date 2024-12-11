package org.example.models;

public class Usuario {
    public enum TipoUsuario {
        ADMINISTRADOR, EDITOR, VISUALIZADOR
    }

    private String email;
    private String senha;
    private String nome;
    private TipoUsuario tipoUsuario;

    public Usuario(String email, String senha, String nome, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
