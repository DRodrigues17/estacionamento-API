package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoResponseConverter implements VeiculoConverter<Veiculo, VeiculoResponseDto> {


    @Override
    public VeiculoResponseDto convert(Veiculo veiculo) {
        return VeiculoResponseDto.builder()
                .id(veiculo.getId())
                .tipoVeiculo(veiculo.getTipoVeiculo())
                .placa(veiculo.getPlaca())
                .assinante(
                        veiculo.getAssinante() == null
                                ? null
                                : AssinanteResponseDto.builder()
                                .nome(veiculo.getAssinante().getNome())
                                .cpf(veiculo.getAssinante().getCpf())
                                .creditoTotal(veiculo.getAssinante().getCreditoTotal())
                                .build())
                .build();
    }
}
