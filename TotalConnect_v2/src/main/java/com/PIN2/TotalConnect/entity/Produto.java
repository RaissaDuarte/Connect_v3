package com.PIN2.TotalConnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_produtos")
@Getter
@Setter


public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;
    private String nome;
    private Double peso;
    private Double dimensao;
    private Double quantidade;
    private Double valor;
    private String imagem; 
    
}


