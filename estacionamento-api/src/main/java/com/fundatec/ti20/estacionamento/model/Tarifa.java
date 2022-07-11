package com.fundatec.ti20.estacionamento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
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

    @NotBlank(message = "por favor informe o veículo")
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Positive(message = "o valor precisa ser positivo")
    @Pattern(regexp = "^[1-9]\\d{0,2}(\\.\\d{3})*,\\d{2}$", message = "valor digitado no formato errado")
    @Column(nullable = false)
    private BigDecimal valor;
}
