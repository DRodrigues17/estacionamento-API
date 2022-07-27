package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.repository.AssinanteRepository;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssinanteService {

    @Autowired
    private final AssinanteRepository repository;



    public Assinante findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Assinante não encontrado"));
    }

    public List<Assinante> findAll() {
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
