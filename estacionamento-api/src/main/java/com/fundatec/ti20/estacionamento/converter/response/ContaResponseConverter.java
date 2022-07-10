package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaResponseConverter implements ContaConverter<Conta, ContaResponseDto> {

    @Override
    public ContaResponseDto convert(Conta conta) {
        return ContaResponseDto.builder()
                .id(conta.getId())
                .entrada(conta.getEntrada())
                .saida(conta.getSaida())
                .veiculo(conta.getVeiculo())
                .valor(conta.getValor())
                .build();
    }
}

