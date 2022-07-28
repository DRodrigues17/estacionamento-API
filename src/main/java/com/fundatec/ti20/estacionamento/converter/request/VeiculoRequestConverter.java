package com.fundatec.ti20.estacionamento.converter.request;

import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoRequestConverter implements VeiculoConverter<VeiculoResponseDto, Veiculo> {

    @Override
    public Veiculo convert(VeiculoResponseDto veiculo) {
        return Veiculo.builder()
                .tipoVeiculo(veiculo.getTipoVeiculo())
                .placa(veiculo.getPlaca())
                .assinante(
                        veiculo.getAssinante() == null
                                ? null
                                : Assinante.builder()
                                .nome(veiculo.getAssinante().getNome())
                                .cpf(veiculo.getAssinante().getCpf())
                                .creditoTotal(veiculo.getAssinante().getCreditoTotal())
                                .build())
                .build();
    }

}

