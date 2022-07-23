package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoRequestConverter implements EnderecoConverter<EnderecoResponseDto, Endereco> {
    @Override
    public Endereco convert(EnderecoResponseDto endereco) {
        return Endereco.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .build();
    }
}
