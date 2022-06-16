package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EnderecoDto findEmderecoById(@PathVariable("id") Integer id) {
        Optional<EnderecoDto> optionalEnderecoDto = service.fingById(id);
        if (optionalEnderecoDto.isPresent())
            return optionalEnderecoDto.get();

        return null;
    }

    @GetMapping
    public  Iterable<Endereco> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco){
        return service.salvar(endereco);
    }


    @PutMapping
    public Endereco atualizar(@RequestBody Endereco endereco){
        return service.atualizar(endereco);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
