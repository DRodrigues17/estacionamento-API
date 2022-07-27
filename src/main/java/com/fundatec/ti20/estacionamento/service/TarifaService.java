package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.repository.TarifaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@AllArgsConstructor
public class TarifaService {

    @Autowired
    private final TarifaRepository repository;


    public Tarifa find(TipoTarifa tipoTarifa, TipoVeiculo tipoVeiculo) {
        return repository.findByTipoTarifaAndTipoVeiculo(tipoTarifa, tipoVeiculo).orElseThrow(() -> new RuntimeException("Tarifa não encontrada"));
    }

    public List<Tarifa> findAll() {
        return repository.findAll();
    }

    public Tarifa findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarifa não encontrada"));
    }

    public Tarifa salvar(Tarifa tarifa) {
        return repository.save(tarifa);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    //Revisar método requerido pelo professor
//    public void MontarTarifa(Tarifa tarifa) {
//        Conta contaUtilizada = tarifa.getConta();
//        long tempoEmMinutos = contaService.descobrirDuracaoEmMinutos(contaUtilizada);
//        TipoVeiculo tipoVeiculo = contaUtilizada.getVeiculo().getTipoVeiculo();
//        tarifa.setValor(BigDecimal.valueOf(calculoService.calcular(tipoVeiculo, tempoEmMinutos)));
//        contaUtilizada.setValorPagamento(tarifa.getValor());
//    }



}