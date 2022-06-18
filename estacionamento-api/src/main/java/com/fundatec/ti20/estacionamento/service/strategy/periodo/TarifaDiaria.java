package com.fundatec.ti20.estacionamento.service.strategy.periodo;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;

import static com.fundatec.ti20.estacionamento.util.Constants.*;

public class TarifaDiaria implements TarifaPorPeriodoStrategy {

	@Override
	public boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos) {
		return periodoUtilizadoEmMinutos > SEIS_HORAS;
	}

	@Override
	public double calcular(Veiculo veiculo, Long periodoUtilizadoEmMinutos) {
		return getTarifaVeiculoStrategy(veiculo)
				.getValorTarifa(TipoTarifa.DIARIA);
	}

}
