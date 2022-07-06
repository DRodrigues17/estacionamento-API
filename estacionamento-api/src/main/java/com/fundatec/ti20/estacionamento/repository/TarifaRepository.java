package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
TarifaRepository extends CrudRepository<Tarifa, Integer> {
}
