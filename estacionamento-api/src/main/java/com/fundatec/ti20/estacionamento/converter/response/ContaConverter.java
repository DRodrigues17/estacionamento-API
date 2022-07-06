package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.ContaDto;
import com.fundatec.ti20.estacionamento.model.Conta;

public interface ContaConverter<M extends Conta, R extends ContaDto> {

    R convert(M conta);
}
