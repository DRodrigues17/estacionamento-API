package com.fundatec.ti20.estacionamento.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeiculoRequestDto {

    private TipoVeiculo tipoVeiculo;
    private String placa;
    private AssinanteRequestDto assinante;

}
