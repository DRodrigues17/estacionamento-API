package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.EnderecoResponseConverter;
import com.fundatec.ti20.estacionamento.dto.EnderecoDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

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
    public  ResponseEntity<List<EnderecoDto>> findAll(){
        Iterable<Endereco> endereco = service.findAll();
        List<EnderecoDto> enderecoDto = StreamSupport.stream(endereco.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(enderecoDto);
    }
    @PostMapping
    public ResponseEntity<EnderecoDto> salvar(@RequestBody Endereco endereco){
        Endereco enderecoDto = service.salvar(endereco);
        return ResponseEntity.ok(converter.convert(enderecoDto));
    }
    @PutMapping
    public ResponseEntity<EnderecoDto> atualizar(@RequestBody Endereco endereco){
        Endereco enderecoDto = service.atualizar(endereco);
        return ResponseEntity.ok(converter.convert(enderecoDto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
