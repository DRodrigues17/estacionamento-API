package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.stereotype.Component;

@Component
public class AssinanteResponseConverter implements AssinanteConverter<Assinante, AssinanteResponseDto> {

    @Override
    public AssinanteResponseDto convert(Assinante assinante) {
        return AssinanteResponseDto.builder()
                .id(assinante.getId())
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }
}
