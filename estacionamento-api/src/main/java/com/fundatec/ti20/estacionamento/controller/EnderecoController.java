package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.EnderecoResponseConverter;
import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {
    @Autowired
    private final EnderecoService service;
    @Autowired
    private final EnderecoResponseConverter converter;

    public EnderecoController(EnderecoService service, EnderecoResponseConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<EnderecoResponseDto> findEmderecoById(@PathVariable("id") Integer id) {
        Endereco endereco = service.findById(id);
        return ResponseEntity.ok(converter.convert(endereco));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  ResponseEntity<List<EnderecoResponseDto>> findAll(){
        Iterable<Endereco> endereco = service.findAll();
        List<EnderecoResponseDto> enderecoResponseDto = StreamSupport.stream(endereco.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(enderecoResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoResponseDto> salvar(@RequestBody Endereco endereco){
        Endereco enderecoDto = service.salvar(endereco);
        return ResponseEntity.ok(converter.convert(enderecoDto));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnderecoResponseDto> atualizar(@RequestBody Endereco endereco){
        Endereco enderecoDto = service.atualizar(endereco);
        return ResponseEntity.ok(converter.convert(enderecoDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
