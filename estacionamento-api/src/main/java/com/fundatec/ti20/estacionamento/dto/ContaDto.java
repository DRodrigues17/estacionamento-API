package com.fundatec.ti20.estacionamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaDto {

private LocalDateTime entrada;
private LocalDateTime saida;
private TipoTarifa tipoTarifa;
private TipoVeiculo tipoVeiculo;
private Double tarifa;


}
