package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;

public interface ContaConverter<M extends Conta, R extends ContaResponseDto> {

    R convert(M conta);
}
