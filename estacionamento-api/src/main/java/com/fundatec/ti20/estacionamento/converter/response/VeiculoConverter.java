package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;

public interface VeiculoConverter <M extends Veiculo, R extends VeiculoDto> {
    R convert(M veiculo);
}
