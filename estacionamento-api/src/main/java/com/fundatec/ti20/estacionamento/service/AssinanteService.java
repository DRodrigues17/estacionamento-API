package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.repository.AssinanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinanteService {

    @Autowired
    private final AssinanteRepository repository;

    public AssinanteService(AssinanteRepository repository) {
        this.repository = repository;
    }

    public Assinante fingById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Assinante não encontrado"));
    }

    public Iterable<Assinante> findAll() {
        return repository.findAll();
    }

    public Assinante salvar(Assinante assinante) {
        return repository.save(assinante);
    }

    public Assinante atualizar(Assinante assinante) {
        return repository.save(assinante);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
