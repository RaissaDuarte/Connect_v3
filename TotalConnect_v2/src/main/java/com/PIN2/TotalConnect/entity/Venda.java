package com.PIN2.TotalConnect.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vendas")
@Getter
@Setter

public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venda;

    private Integer id_cliente;
    
    @Column(nullable = true)
    private Double desconto;
    @Column(nullable = true)
    private Double valorTotal;

    @OneToMany
    private List<ItemVenda> itensVenda;

}

