package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name = "tb_veiculo")
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false, length = 7)
    private String placa;

    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "assinante_id")
    private Assinante assinante;

    public TipoVeiculo getTipo() {
        return tipoVeiculo;
    }
}

