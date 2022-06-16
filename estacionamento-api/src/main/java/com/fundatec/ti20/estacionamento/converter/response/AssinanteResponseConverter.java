package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.stereotype.Component;

@Component
public class AssinanteResponseConverter implements AssinanteConverter<Assinante, AssinanteDto> {


    @Override
    public AssinanteDto convert(Assinante assinante) {
        return AssinanteDto.builder()
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .veiculos(assinante.getVeiculos())
                .build();
    }
}
