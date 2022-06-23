package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;

public interface EnderecoConverter <M extends Endereco, R extends EnderecoDto> {

    R convert(M endereco);

}
