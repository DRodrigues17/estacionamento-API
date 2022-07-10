package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResponseDto {

    private Integer id;
private LocalDateTime entrada;
private LocalDateTime saida;
private Veiculo veiculo;
private BigDecimal valor;



}
