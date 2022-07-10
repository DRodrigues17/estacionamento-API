package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.stereotype.Component;

@Component
public class AssinanteRequestConverter implements AssinanteConverter<AssinanteResponseDto, Assinante> {

    @Override
    public Assinante convert(AssinanteResponseDto assinante) {
        return Assinante.builder()
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }
}
