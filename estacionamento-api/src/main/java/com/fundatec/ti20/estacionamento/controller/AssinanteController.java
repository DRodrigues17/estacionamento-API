package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.AssinanteResponseConverter;
import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/assinante")
public class AssinanteController {

    @Autowired
    private final AssinanteService service;

    @Autowired
    private final AssinanteResponseConverter converter;

    public AssinanteController(AssinanteService assinanteService, AssinanteResponseConverter converter) {
        this.service = assinanteService;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<AssinanteDto> findAssinanteById(@PathVariable Integer id) {
        Assinante assinante = service.findById(id);
        return ResponseEntity.ok(converter.convert(assinante));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AssinanteDto>> findAll(){
        Iterable<Assinante> assinante = service.findAll();
        List<AssinanteDto> assinanteDto = StreamSupport.stream(assinante.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(assinanteDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AssinanteDto> salvar(@RequestBody Assinante assinante) {
        Assinante assinanteDto = service.salvar(assinante);
        return ResponseEntity.ok(converter.convert(assinanteDto));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AssinanteDto> atualizar(@RequestBody Assinante assinante) {
        Assinante assinanteDto = service.atualizar(assinante);
        return ResponseEntity.ok(converter.convert(assinanteDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


}
