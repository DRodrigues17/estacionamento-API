package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Optional<EnderecoDto> fingById(Integer id) {
        Endereco model = repository.findById(id).get();
        return Optional.of(new EnderecoDto(model));
    }

    public Iterable<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco atualizar(Endereco endereco){
        return repository.save(endereco);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
