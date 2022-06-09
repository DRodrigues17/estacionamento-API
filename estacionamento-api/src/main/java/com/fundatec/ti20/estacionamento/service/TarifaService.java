package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.repository.TarifaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarifaService {

    private final TarifaRepository repository;

    public TarifaService(TarifaRepository repository) {
        this.repository = repository;
    }

    public Optional<Tarifa> fingById(Integer id){
        return repository.findById(id);
    }

    public Iterable<Tarifa> findAll(){
        return repository.findAll();
    }

    public Tarifa salvar(Tarifa tarifa){
        return repository.save(tarifa);
    }

    public Tarifa atualizar(Tarifa tarifa){
        return repository.save(tarifa);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
