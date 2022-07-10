package com.fundatec.ti20.estacionamento.model;

import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "assinante_id", nullable = true)
    private Assinante assinante;



    public TipoVeiculo getEhDoTipo() {
        return tipoVeiculo;
    }

    public boolean temAssinante() {
        return assinante != null;
    }
}

