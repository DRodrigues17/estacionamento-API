package com.fundatec.ti20.estacionamento.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_endereco")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String cep;

}
