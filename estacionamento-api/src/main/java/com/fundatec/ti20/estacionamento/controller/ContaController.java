package com.fundatec.ti20.estacionamento.controller;


import com.fundatec.ti20.estacionamento.converter.response.ContaResponseConverter;
import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contas")
public class ContaController {

    @Autowired
    private final ContaService service;
    @Autowired
    private final ContaResponseConverter converter;

    public ContaController(ContaService service, ContaResponseConverter converter) {
        this.service = service;
        this.converter = converter;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<ContaResponseDto> findContaById(@PathVariable Integer id) {
        Conta conta = service.findById(id);
        return ResponseEntity.ok(converter.convert(conta));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<ContaResponseDto>> findAll(){
        List<Conta> conta = service.findAll();
        List<ContaResponseDto> contaResponseDto = conta.stream()
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(contaResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaResponseDto> salvar(@RequestBody Conta conta) {
        Conta contaDto = service.salvar(conta);
        return ResponseEntity.ok(converter.convert(contaDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaResponseDto> atualizar(@RequestBody Conta conta, @PathVariable Integer id) {
        Conta contaDto = service.salvar(conta);
        return ResponseEntity.ok(converter.convert(contaDto));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaResponseDto> patch(@PathVariable Integer id, @RequestBody ContaPatchRequest update){
        Conta conta =service.findById(id);
        conta.setSaida(update.getSaida());
        return ResponseEntity.ok(converter.convert(service.salvar(conta)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }

}
