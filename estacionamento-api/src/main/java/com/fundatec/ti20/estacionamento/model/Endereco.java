package com.fundatec.ti20.estacionamento.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Assinante assinante;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false, length = 10)
    private String cep;

}
