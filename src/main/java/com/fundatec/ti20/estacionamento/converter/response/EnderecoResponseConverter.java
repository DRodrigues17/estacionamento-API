package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoResponseConverter implements EnderecoConverter<Endereco, EnderecoResponseDto> {
    @Override
    public EnderecoResponseDto convert(Endereco endereco) {
        return EnderecoResponseDto.builder()
                .id(endereco.getId())
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .build();
    }
}
