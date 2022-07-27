package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.StatusPagamento;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {

    @Autowired
    private final ContaRepository repository;
    @Autowired
    private final VeiculoService veiculoService;


    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Conta"));
    }

    public Conta salvar(Conta conta) {
        return repository.save(conta);
    }

    public Conta fecharConta(Integer id, LocalDateTime saida) {
        Conta conta = findById(id);
        conta.setSaida(saida);
        return conta;
    }
    public Long descobrirDuracaoEmMinutos(Conta conta) {
        return Duration.between(conta.getEntrada(), conta.getSaida()).toMinutes();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Conta criarNovaConta(Conta conta, Integer idVeiculo){
        if(veiculoService.findById(idVeiculo)==null){
            throw new ObjectNotFoundException("veiculo");
        }
        Veiculo veiculo = veiculoService.findById(idVeiculo);
        conta.setVeiculo(veiculo);
        conta.setStatus(StatusPagamento.ABERTA);
        try {
            return repository.save(conta);
        } catch (ConflitoException e){
            throw new ConflitoException("cliente");
        }
    }

}
