package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;

public interface ContaConverter<M extends ContaResponseDto, R extends Conta> {

    R convert(M conta);
}
