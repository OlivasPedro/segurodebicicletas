package com.example.model;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private LocalDate dataNascimento;
    private String celular;
    private String cep;
    private String cpf;
    private String email;
    private String senha;

    public Usuario() {
    }
    
    public Usuario(String nome, LocalDate localDate, String celular, String cep, String cpf, String email, String senha) {
        this.nome = nome;
        this.dataNascimento = localDate;
        this.celular = celular;
        this.cep = cep;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome2, String senha2, String cpf2) {
        this.nome = nome2;
        this.senha = senha2;
        this.cpf = cpf2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
