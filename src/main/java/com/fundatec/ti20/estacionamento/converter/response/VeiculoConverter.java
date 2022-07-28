package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;

public interface VeiculoConverter <M extends Veiculo, R extends VeiculoResponseDto> {
    R convert(M veiculo);
}
