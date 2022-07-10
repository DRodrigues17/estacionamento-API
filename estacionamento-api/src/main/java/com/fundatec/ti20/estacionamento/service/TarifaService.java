package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.repository.TarifaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@AllArgsConstructor
public class TarifaService {

    @Autowired
    private final TarifaRepository repository;
    @Autowired
    private final CalcularContaService service;

    public Tarifa find(Integer idVeiculo, Integer idConta) {
        return repository.findByIdVeiculoAndIdConta(idVeiculo, idConta).orElseThrow(() -> new RuntimeException("Tarifa não encontrada"));
    }

    public Tarifa salvar(Tarifa tarifa) {
        return repository.save(tarifa);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    //Revisar método requerido pelo professor
    public void fecharTarifa(Conta conta) {
        Veiculo veiculo = conta.getVeiculo();
        TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
        if (conta.getVeiculo().temAssinante()) {
            double valorTarifa = (service.calcular(tipoVeiculo, conta.descobrirDuracaoEmMinutos())) * 0.90;
        }
        double valorTarifa = service.calcular(tipoVeiculo, conta.descobrirDuracaoEmMinutos());
        Tarifa tarifa = Tarifa.builder().valor(new BigDecimal(valorTarifa)).build();
        salvar(tarifa);
    }

}