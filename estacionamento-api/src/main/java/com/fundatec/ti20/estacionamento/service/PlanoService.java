package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.dto.PlanoDto;
import com.fundatec.ti20.estacionamento.model.Plano;
import com.fundatec.ti20.estacionamento.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private final PlanoRepository repository;

    public PlanoService(PlanoRepository repository) {
        this.repository = repository;
    }

    public Optional<PlanoDto> fingById(Integer id) {
        Plano model = repository.findById(id).get();
        return Optional.of(new PlanoDto(model));
    }

    public Iterable<Plano> findAll() {
        return repository.findAll();
    }

    public Plano salvar(Plano plano) {
        return repository.save(plano);
    }

    public Plano atualizar(Plano plano){
        return repository.save(plano);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
