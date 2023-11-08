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
@Table(name = "tb_transportadora")
@Getter
@Setter
public class Transportadora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_transp", nullable = false)
    private String nome;

    @Column(name = "cidade_transp", nullable = false)
    private String cidade;

    @Column(name = "precoKM_transp", nullable = false)
    private float precoKM;

    public Transportadora() {
    }

    public Transportadora(String nome, String cidade, float precoKM) {
        this.nome = nome;
        this.cidade = cidade;
        this.precoKM = precoKM;
    }
    
}
