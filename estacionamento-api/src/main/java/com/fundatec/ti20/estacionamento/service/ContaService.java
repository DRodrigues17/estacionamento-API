package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

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

    public Conta fecharConta(Integer id) {
        Conta conta = findById(id);
        setHorarioSaida(conta);
        service.fecharTarifa(conta);
        return salvar(conta);
    }

    public Conta setHorarioSaida(Conta conta){
        conta.setSaida(LocalDateTime.now());
        return repository.save(conta);
    }

    public Conta setHorarioEntrada(Conta conta){
        conta.setEntrada(LocalDateTime.now());
        return repository.save(conta);
    }

    public void iniciarConta(Conta conta){
        setHorarioEntrada(conta);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
