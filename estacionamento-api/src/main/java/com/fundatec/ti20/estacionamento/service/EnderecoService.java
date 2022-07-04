package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public Endereco findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
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
