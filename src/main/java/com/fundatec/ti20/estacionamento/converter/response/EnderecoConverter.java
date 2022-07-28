package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;

public interface EnderecoConverter <M extends Endereco, R extends EnderecoResponseDto> {

    R convert(M endereco);

}
