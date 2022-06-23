package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoResponseConverter implements EnderecoConverter<Endereco, EnderecoDto> {
    @Override
    public EnderecoDto convert(Endereco endereco) {
        return EnderecoDto.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .build();
    }
}
