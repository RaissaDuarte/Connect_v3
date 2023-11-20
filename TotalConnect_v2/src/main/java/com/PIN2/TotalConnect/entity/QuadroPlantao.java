// package com.PIN2.TotalConnect.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Table(name = "tb_quadroPlantao")
// @Getter
// @Setter
// public class QuadroPlantao {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "id_funcionario", nullable = false)
//     private Funcionario funcionario;

//     @Column(name = "mensagem", nullable = false)
//     private String mensagem;

//     public QuadroPlantao() {
//     }

//     public QuadroPlantao(Funcionario funcionario, String mensagem) {
//         this.funcionario = funcionario;
//         this.mensagem = mensagem;
//     }
// }
