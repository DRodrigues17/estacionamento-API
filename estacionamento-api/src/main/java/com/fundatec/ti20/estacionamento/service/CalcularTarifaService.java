package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.instance.TarifaPorPeriodoInstance;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.strategy.periodo.TarifaPorPeriodoStrategy;

public class CalcularTarifaService {

	public double calcular(Veiculo veiculo, long periodoUtilizadoEmMinutos) {
		return getTarifaPeriodoStrategy(periodoUtilizadoEmMinutos)
				.calcular(veiculo, periodoUtilizadoEmMinutos);
	}

	private TarifaPorPeriodoStrategy getTarifaPeriodoStrategy(long periodoUtilizadoEmMinutos) {
		return TarifaPorPeriodoInstance.INSTANCIAS.get()
				.filter(estrategia -> estrategia.compreendePeriodoUtilizado(periodoUtilizadoEmMinutos))
				.findFirst()
				.orElseThrow(() 
						-> new IllegalStateException("Nenhuma estratégia implementada para o período utilizado"));
	}
}
