package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.repository.AssinanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssinanteService {

    @Autowired
    private final AssinanteRepository repository;

    public AssinanteService(AssinanteRepository repository) {
        this.repository = repository;
    }

    public Optional<AssinanteDto> fingById(Integer id) {
        Assinante model = repository.findById(id).get();
        return Optional.of(new AssinanteDto(model));
    }

    public Iterable<Assinante> findAll() {
        return repository.findAll();
    }

    public Assinante salvar(Assinante assinante) {
        return repository.save(assinante);
    }

    public Assinante atualizar(Assinante assinante){
        return repository.save(assinante);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
