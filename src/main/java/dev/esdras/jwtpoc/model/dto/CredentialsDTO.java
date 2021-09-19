package dev.esdras.jwtpoc.model.dto;

public class CredentialsDTO {
    private String email;
    private String senha;

    public CredentialsDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public CredentialsDTO() {
    }

    public String getEmail() {
        return email;
    }

    public CredentialsDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public CredentialsDTO setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
