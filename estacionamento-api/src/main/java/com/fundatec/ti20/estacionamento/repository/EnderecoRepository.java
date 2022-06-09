package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
}
