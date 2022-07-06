package com.fundatec.ti20.estacionamento.service.strategy.periodo;


import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;

import static com.fundatec.ti20.estacionamento.util.Constants.*;


public class TarifaAteUmaHora implements TarifaPorPeriodoStrategy {

	@Override
	public boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos) {
		return periodoUtilizadoEmMinutos > MEIA_HORA
				&& periodoUtilizadoEmMinutos <= UMA_HORA;
	}

	@Override
	public double calcular(TipoVeiculo veiculo, Long periodoUtilizadoEmMinutos) {
		return getTarifaVeiculoStrategy(veiculo).getValorTarifa(TipoTarifa.ATE_UMA_HORA);
	}
}
