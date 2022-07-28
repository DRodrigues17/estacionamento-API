package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;

public interface EnderecoConverter <M extends EnderecoResponseDto, R extends Endereco> {

    R convert(M endereco);

}
