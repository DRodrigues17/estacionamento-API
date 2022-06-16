package com.fundatec.ti20.estacionamento.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_assinante")
public class Assinante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    @Column(nullable = false)
    @OneToMany(mappedBy = "assinante")
    private List<Veiculo> veiculos;
}
