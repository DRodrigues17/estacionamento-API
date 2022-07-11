package com.fundatec.ti20.estacionamento.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


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
    @NotBlank(message = "nome necessário, afinal todos temos um")
    private String nome;

    @NotBlank(message = "cpf requirido para cadastro")
    @Size(min = 11, max = 11, message = "quantidade de digitos inválida")
    @Pattern(regexp = "(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})\n",
            message = "informe o cpf de forma válida, tal como consta no docummento")
    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, name = "credito_total")
    @PositiveOrZero
    private BigDecimal creditoTotal;

    @NotBlank(message = "informe o endereço do assinante")
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
