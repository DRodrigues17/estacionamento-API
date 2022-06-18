package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Table(name = "tb_tarifa")
@NoArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "veiculo", nullable = false)
//    private Veiculo veiculo;

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

    private Tarifa(TarifaBuilder builder) {
        //this.veiculo = builder.veiculo;
        this.entrada = builder.entrada;
        this.saida = builder.saida;
        this.valor = builder.valor;
    }
    public static TarifaBuilder builder() {
        return new TarifaBuilder();
    }

//    public Veiculo getVeiculo() {
//        return veiculo;
//    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public BigDecimal getValor() {
        return valor;
    }

//    @Override
//    public String toString() {
//        return "Tarifa [veiculo=" + veiculo + ", entrada=" + entrada + ", saida=" + saida + ", valor=" + valor + "]";
//    }

    public static class TarifaBuilder {
        private Veiculo veiculo;
        private Date entrada;
        private Date saida;
        private BigDecimal valor;

        private TarifaBuilder() {
        }

        public TarifaBuilder veiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
            return this;
        }

        public TarifaBuilder entrada(Date entrada) {
            this.entrada = entrada;
            return this;
        }

        public TarifaBuilder saida(Date saida) {
            this.saida = saida;
            return this;
        }

        public TarifaBuilder valor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public Tarifa build() {
            return new Tarifa(this);
        }
    }
}
