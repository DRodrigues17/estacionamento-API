package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {

    @Autowired
    private final ContaRepository repository;
    @Autowired
    private final TarifaService service;

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public Conta salvar(Conta conta) {
        return repository.save(conta);
    }

    public Conta fecharConta(Integer id, LocalDateTime saida) {
        Conta conta = findById(id);
        conta.setSaida(saida);
        return salvar(conta);
    }

    public Long descobrirDuracaoEmMinutos(Conta conta) {
        return Duration.between(conta.getEntrada(), conta.getSaida()).toMinutes();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
