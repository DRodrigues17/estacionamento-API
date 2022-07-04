package com.fundatec.ti20.estacionamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarifaDto {

    private Veiculo veiculo;
    private BigDecimal valor;

}
