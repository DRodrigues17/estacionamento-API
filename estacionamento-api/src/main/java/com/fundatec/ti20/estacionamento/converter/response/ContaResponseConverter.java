package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.ContaDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaResponseConverter implements ContaConverter<Conta, ContaDto> {

    @Override
    public ContaDto convert(Conta conta) {
        return ContaDto.builder()
                .entrada(conta.getEntrada())
                .saida(conta.getSaida())
                .tipoTarifa(conta.getTipoTarifa())
                .tipoVeiculo(conta.getTipoVeiculo())
                .build();
    }
}

