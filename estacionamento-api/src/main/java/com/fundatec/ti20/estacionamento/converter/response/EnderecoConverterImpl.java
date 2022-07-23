package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.request.EnderecoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverterImpl implements EnderecoConverter<Endereco, EnderecoResponseDto, EnderecoRequestDto> {
    @Override
    public EnderecoResponseDto convert(Endereco endereco) {
        return EnderecoResponseDto.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .build();
    }

    @Override
    public Endereco convert(EnderecoRequestDto endereco) {
        return Endereco.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .build();
    }
}
