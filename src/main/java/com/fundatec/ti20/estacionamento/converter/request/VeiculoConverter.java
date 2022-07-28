package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;

public interface VeiculoConverter <M extends VeiculoResponseDto, R extends Veiculo> {

    R convert(M veiculo);
}
