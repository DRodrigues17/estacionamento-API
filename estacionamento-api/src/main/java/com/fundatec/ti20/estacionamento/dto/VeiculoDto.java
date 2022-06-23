package com.fundatec.ti20.estacionamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.converter.response.VeiculoConverter;
import com.fundatec.ti20.estacionamento.converter.response.VeiculoResponseConverter;
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

}
