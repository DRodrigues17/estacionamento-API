package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoResponseConverter implements VeiculoConverter<Veiculo, VeiculoDto> {


    @Override
    public VeiculoDto convert(Veiculo veiculo) {
            return VeiculoDto.builder()
                            .tipoVeiculo(veiculo.getTipoVeiculo())
                            .placa(veiculo.getPlaca())
                            .assinante(
                                    veiculo.getAssinante() == null
                                            ? null
                                            : AssinanteDto.builder()
                                            .nome(veiculo.getAssinante().getNome())
                                            .cpf(veiculo.getAssinante().getCpf())
                                            .creditoTotal(veiculo.getAssinante().getCreditoTotal())
                                            .build())
                            .build();
    }
}
