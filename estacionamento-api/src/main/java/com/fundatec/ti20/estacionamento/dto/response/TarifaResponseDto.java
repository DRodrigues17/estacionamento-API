package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarifaResponseDto {

    private Integer id;
    private TipoVeiculo tipoVeiculo;
    private TipoTarifa tipoTarifa;
    private BigDecimal valor;

}
