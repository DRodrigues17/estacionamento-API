package com.fundatec.ti20.estacionamento.model;

import com.fundatec.ti20.estacionamento.model.Enum.TipoVeiculo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Assinante assinante;
}
