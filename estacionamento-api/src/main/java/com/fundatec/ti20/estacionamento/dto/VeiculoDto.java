package com.fundatec.ti20.estacionamento.dto;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VeiculoDto {

    private TipoVeiculo tipoVeiculo;
    private String placa;
    private Assinante assinante;

    public VeiculoDto() {
    }


    public VeiculoDto(Veiculo veiculo) {
        tipoVeiculo = veiculo.getTipoVeiculo();
        placa = veiculo.getPlaca();
        assinante = veiculo.getAssinante();
    }

    public VeiculoDto(TipoVeiculo tipoVeiculo, String placa, Assinante assinante) {
        this.tipoVeiculo = tipoVeiculo;
        this.placa = placa;
        this.assinante = assinante;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public Assinante getAssinante() {
        return assinante;
    }
}
