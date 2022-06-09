package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Plano;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends CrudRepository<Plano, Integer> {
}
