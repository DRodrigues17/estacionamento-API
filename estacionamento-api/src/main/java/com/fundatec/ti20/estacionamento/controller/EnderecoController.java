package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.EnderecoResponseConverter;
import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    @Autowired
    private final EnderecoService service;

    @Autowired
    private final EnderecoResponseConverter converter;

    public EnderecoController(EnderecoService enderecoService, EnderecoResponseConverter converter) {
        this.service = enderecoService;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> findEmderecoById(@PathVariable("id") Integer id) {
        Endereco endereco = service.fingById(id);
        return ResponseEntity.ok(converter.convert(endereco));
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
