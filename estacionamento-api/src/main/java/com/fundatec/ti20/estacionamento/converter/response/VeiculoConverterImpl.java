package com.fundatec.ti20.estacionamento.converter.response;

import com.fundatec.ti20.estacionamento.dto.request.VeiculoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VeiculoConverterImpl implements VeiculoConverter<Veiculo, VeiculoResponseDto, VeiculoRequestDto> {


    private final AssinanteService assinanteService;

    @Override
    public VeiculoResponseDto convert(Veiculo veiculo) {
        return VeiculoResponseDto.builder()
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

    @Override
    public Veiculo convert(VeiculoRequestDto veiculo) {
        return Veiculo.builder()
                .tipoVeiculo(veiculo.getTipoVeiculo())
                .assinante(assinanteService.findById(veiculo.getAssinanteId()))
                .placa(veiculo.getPlaca())
                .build();
    }


}
