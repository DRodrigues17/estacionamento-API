package com.fundatec.ti20.estacionamento.service;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {


    @Autowired
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
    }

    public Veiculo findByplaca(String placa) {
        return repository.findByPlaca(placa).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }
    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo) {
        return repository.save(veiculo);
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
