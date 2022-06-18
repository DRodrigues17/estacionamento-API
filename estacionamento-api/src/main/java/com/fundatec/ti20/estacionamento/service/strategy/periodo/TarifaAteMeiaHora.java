package com.fundatec.ti20.estacionamento.service.strategy.periodo;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;

import static com.fundatec.ti20.estacionamento.util.Constants.MEIA_HORA;


public class TarifaAteMeiaHora implements TarifaPorPeriodoStrategy {

    @Override
    public boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos) {
        return periodoUtilizadoEmMinutos <= MEIA_HORA;
    }

    @Override
    public double calcular(Veiculo veiculo, Long periodoUtilizadoEmMinutos) {
        return getTarifaVeiculoStrategy(veiculo).getValorTarifa(TipoTarifa.ATE_MEIA_HORA);
    }
}
