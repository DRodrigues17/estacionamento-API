package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {


    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Optional<Veiculo> fingById(Integer id){
        return repository.findById(id);
    }

    public Iterable<Veiculo> findAll(){
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
