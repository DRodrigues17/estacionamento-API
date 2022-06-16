package com.fundatec.ti20.estacionamento.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "tb_plano")
public class Plano {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    @JoinColumn(name = "assinante_id")
    private List<Assinante> assinante;

    @Column(nullable = false)
    private BigDecimal valor;
}
