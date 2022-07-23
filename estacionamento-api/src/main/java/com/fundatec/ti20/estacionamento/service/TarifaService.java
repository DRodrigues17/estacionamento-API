package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.repository.TarifaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TarifaService {

    @Autowired
    private final TarifaRepository repository;
    @Autowired
    private final CalcularContaService calculoService;
    @Autowired
    private final VeiculoService veiculoService;

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
//    public Tarifa fecharTarifa(Conta conta) {
//
//        double valorTarifa = calculoService.calcular(conta.getTipoVeiculo(), conta.descobrirDuracaoEmMinutos());
//        Tarifa tarifa = Tarifa.builder()
//                .veiculo(conta.g)
//                .valor(new BigDecimal(valorTarifa))
//                .build();
//        return salvar(tarifa);
//    }

}