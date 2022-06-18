package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
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


    @Column(nullable = false)
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "assinante", targetEntity = Veiculo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;


}
