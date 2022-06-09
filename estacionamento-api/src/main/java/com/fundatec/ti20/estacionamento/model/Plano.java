package com.fundatec.ti20.estacionamento.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Plano {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Assinante assinante;

    @Column(nullable = false)
    private BigDecimal valor;
}
