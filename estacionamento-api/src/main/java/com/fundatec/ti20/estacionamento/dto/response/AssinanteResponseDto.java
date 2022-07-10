package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssinanteResponseDto {

    private Integer id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private BigDecimal creditoTotal;

}
