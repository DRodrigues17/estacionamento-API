package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;

public interface AssinanteConverter<M extends Assinante, R extends AssinanteResponseDto> {

    R convert(M assinante);
}
