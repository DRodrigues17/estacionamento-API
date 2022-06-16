package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;

public interface AssinanteConverter<M extends Assinante, R extends AssinanteDto> {

    R convert(M assinante);
}
