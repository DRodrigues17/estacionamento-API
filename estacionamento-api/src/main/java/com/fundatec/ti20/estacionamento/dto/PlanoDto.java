package com.fundatec.ti20.estacionamento.dto;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Plano;

import java.math.BigDecimal;
import java.util.List;

public class PlanoDto {

    private List<Assinante> assinante;
    private BigDecimal valor;

    public PlanoDto() {
    }

    public PlanoDto(Plano plano) {
        assinante = plano.getAssinante();
        valor = plano.getValor();
    }

    public PlanoDto(List<Assinante> assinante, BigDecimal valor) {
        this.assinante = assinante;
        this.valor = valor;
    }

    public List<Assinante> getAssinante() {
        return assinante;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
