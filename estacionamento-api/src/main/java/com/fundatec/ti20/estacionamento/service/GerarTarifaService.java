package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.util.DateUtils;


import java.math.BigDecimal;
import java.util.Date;

public class GerarTarifaService {
	
	private final CalcularTarifaService calcularTarifaService;
	
	public GerarTarifaService() {
		calcularTarifaService = new CalcularTarifaService();
	}
	
	public Tarifa gerar(Veiculo veiculo, Date entrada, Date saida) {
		long periodoUtilizadoEmMinutos = DateUtils.obterTempoEmMinutos(entrada, saida);
		BigDecimal valor = BigDecimal.valueOf(calcularTarifaService.calcular(veiculo, periodoUtilizadoEmMinutos));
		
		return Tarifa.builder()
				.veiculo(veiculo)
				.entrada(entrada)
				.saida(saida)
				.valor(valor)
				.build();
	}
	
}
