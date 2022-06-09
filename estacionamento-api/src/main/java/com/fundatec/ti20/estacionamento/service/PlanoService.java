package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Plano;
import com.fundatec.ti20.estacionamento.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoService {

    private final PlanoRepository repository;

    public PlanoService(PlanoRepository repository) {
        this.repository = repository;
    }

    public Optional<Plano> fingById(Integer id){
        return repository.findById(id);
    }

    public Iterable<Plano> findAll(){
        return repository.findAll();
    }

    public Plano salvar(Plano plano){
        return repository.save(plano);
    }

    public Plano atualizar(Plano plano){
        return repository.save(plano);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
