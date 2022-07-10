package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.AssinanteResponseConverter;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
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
    public ResponseEntity<AssinanteResponseDto> findAssinanteById(@PathVariable Integer id) {
        Assinante assinante = service.findById(id);
        return ResponseEntity.ok(converter.convert(assinante));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AssinanteResponseDto>> findAll(){
        Iterable<Assinante> assinante = service.findAll();
        List<AssinanteResponseDto> assinanteResponseDto = StreamSupport.stream(assinante.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(assinanteResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AssinanteResponseDto> salvar(@RequestBody Assinante assinante) {
        Assinante assinanteDto = service.salvar(assinante);
        return ResponseEntity.ok(converter.convert(assinanteDto));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AssinanteResponseDto> atualizar(@RequestBody Assinante assinante) {
        Assinante assinanteDto = service.atualizar(assinante);
        return ResponseEntity.ok(converter.convert(assinanteDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


}
