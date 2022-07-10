package com.fundatec.ti20.estacionamento.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_assinante")
public class Assinante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, name = "credito_total")
    private BigDecimal creditoTotal;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
