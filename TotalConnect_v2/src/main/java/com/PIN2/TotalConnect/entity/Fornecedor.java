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
@Table(name = "tb_fornecedor")
@Getter
@Setter
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fornec", nullable = false)
    private String nome;

    @Column(name = "endereco_fornec", nullable = false)
    private String endereco;

    @Column(name = "telefone_fornec", nullable = false)
    private String telefone;

    @Column(name = "cep_fornec", nullable = false)
    private String cep;

    @Column(name = "cpf_fornec", nullable = false)
    private String cnpj;


    public Fornecedor() {

    }


    public Fornecedor(String nome, String endereco, String telefone, String cep, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.cnpj = cnpj;
    }    
    
}
