package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaRequestConverter implements ContaConverter<ContaResponseDto, Conta> {

    @Override
    public Conta convert(ContaResponseDto conta) {
        return Conta.builder()
                .entrada(conta.getEntrada())
                .saida(conta.getSaida())
                .veiculo(conta.getVeiculo())
                .build();
    }
}

