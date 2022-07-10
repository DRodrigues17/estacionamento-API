package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {


   // Optional<Tarifa> findByIdVeiculoAndIdConta(Integer idVeiculo, Integer idConta);

}
