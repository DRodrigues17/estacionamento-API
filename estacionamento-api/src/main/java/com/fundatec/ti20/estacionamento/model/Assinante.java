package com.fundatec.ti20.estacionamento.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Assinante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private Endereco endereco;
}
