package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo,Integer> {
}
