package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Table(name = "tb_tarifa")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarifa", nullable = false)
    private TipoTarifa tipoTarifa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date entrada;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date saida;

    @Column(nullable = false)
    private BigDecimal valor;
}
