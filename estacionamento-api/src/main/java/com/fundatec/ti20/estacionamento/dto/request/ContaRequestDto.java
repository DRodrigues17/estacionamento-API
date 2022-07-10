package com.fundatec.ti20.estacionamento.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaRequestDto {

private LocalDateTime entrada;
private LocalDateTime saida;
private Veiculo veiculo;



}
