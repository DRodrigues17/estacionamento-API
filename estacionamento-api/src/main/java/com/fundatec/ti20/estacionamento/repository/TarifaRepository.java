package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarifaRepository extends CrudRepository<Tarifa, Integer> {
    Optional<Tarifa> findByIdVeiculoAndIdConta(Integer idVeiculo, Integer idConta);

}
