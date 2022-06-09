package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{id}")
    public Endereco findCityById(@PathVariable("id") Integer id){
        Optional<Endereco> optionalEndereco = enderecoService.fingById(id);
        if (optionalEndereco.isPresent())
            return optionalEndereco.get();

        return null;
    }

    @GetMapping
    public  Iterable<Endereco> findAll(){
        return  enderecoService.findAll();
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.salvar(endereco);
    }


    @PutMapping
    public Endereco atualizar(@RequestBody Endereco endereco){
        return enderecoService.atualizar(endereco);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        enderecoService.delete(id);
    }

}
