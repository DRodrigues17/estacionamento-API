package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {


    @Autowired
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Optional<VeiculoDto> findById(Integer id){
        return repository.findById(id)
                .map(veiculo -> VeiculoDto.builder()
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
                                        .build());
    }
    public Iterable<Veiculo> findAll() {
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
