package com.PIN2.TotalConnect.entity;

public class LoginRequest {
    private String cpf;
    private String senha;

    // construtores, getters e setters

    public LoginRequest() {
        // construtor vazio necessário para deserialização JSON
    }

    public LoginRequest(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

