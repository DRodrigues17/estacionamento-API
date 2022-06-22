package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    @Autowired
    private final EnderecoService service;

    public EnderecoController(EnderecoService enderecoService) {
        this.service = enderecoService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EnderecoDto findById(@PathVariable("id") Integer id) {
        Optional<EnderecoDto> optionalEnderecoDto = service.fingById(id);
        return optionalEnderecoDto.orElse(null);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  Iterable<Endereco> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco){
        return service.salvar(endereco);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Endereco atualizar(@RequestBody Endereco endereco){
        return service.atualizar(endereco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
