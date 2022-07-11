package com.fundatec.ti20.estacionamento.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoRequestDto {

    private String logradouro;
    private String cep;

}
