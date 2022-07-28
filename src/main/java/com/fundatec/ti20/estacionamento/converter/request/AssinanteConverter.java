package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;

public interface AssinanteConverter<M extends AssinanteResponseDto, R extends Assinante> {

    R convert(M assinante);
}
