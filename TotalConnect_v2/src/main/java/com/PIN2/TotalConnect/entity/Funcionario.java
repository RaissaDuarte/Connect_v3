package com.PIN2.TotalConnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_funcionario")
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_func", nullable = false)
    private String nome;

    @Column(name = "cpf_func", nullable = false)
    private String cpf;

    @Column(name = "telefone_func", nullable = false)
    private String telefone;

    @Column(name = "endereco_func", nullable = false)
    private String endereco;

    @Column(name = "cep_func", nullable = false)
    private String cep;
    
    @Column(name = "senha_func", nullable = false)
    private String senha;


    public Funcionario() {

    }    

    public Funcionario(String nome, String cpf, String senha, String endereco, String cep, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
    }
    
}
