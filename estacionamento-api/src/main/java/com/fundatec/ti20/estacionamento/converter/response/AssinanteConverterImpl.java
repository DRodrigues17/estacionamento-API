package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.request.AssinanteRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.stereotype.Component;

@Component
public class AssinanteConverterImpl implements AssinanteConverter<Assinante, AssinanteResponseDto, AssinanteRequestDto> {

    @Override
    public AssinanteResponseDto convert(Assinante assinante) {
        return AssinanteResponseDto.builder()
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }

    @Override
    public Assinante convert(AssinanteRequestDto assinante) {
        return Assinante.builder().nome(assinante.getNome())
                .cpf(assinante.getCpf())
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }
}
