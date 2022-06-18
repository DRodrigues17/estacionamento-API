package com.fundatec.ti20.estacionamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeiculoDto {

    private TipoVeiculo tipoVeiculo;
    private String placa;
    private AssinanteDto assinante;

    public VeiculoDto() {
    }


    public VeiculoDto(Veiculo veiculo) {
        tipoVeiculo = veiculo.getTipoVeiculo();
        placa = veiculo.getPlaca();
    }

    public VeiculoDto(TipoVeiculo tipoVeiculo, String placa, AssinanteDto assinante) {
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

    public AssinanteDto getAssinante() {
        return assinante;
    }
}
