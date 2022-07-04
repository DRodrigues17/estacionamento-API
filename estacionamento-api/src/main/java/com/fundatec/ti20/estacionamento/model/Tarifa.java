package com.fundatec.ti20.estacionamento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@Table(name = "tb_tarifa")
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Column(nullable = false)
    private BigDecimal valor;
}
