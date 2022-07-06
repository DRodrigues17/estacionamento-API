package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
