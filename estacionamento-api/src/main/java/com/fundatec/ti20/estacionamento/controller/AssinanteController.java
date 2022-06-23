package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.AssinanteResponseConverter;
import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AssinanteDto> findAssinanteById(@PathVariable Integer id) {
        Assinante assinante = service.fingById(id);
        return ResponseEntity.ok(converter.convert(assinante));

    }

    @GetMapping
    public Iterable<Assinante> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Assinante salvar(@RequestBody Assinante assinante) {
        return service.salvar(assinante);
    }


    @PutMapping
    public Assinante atualizar(@RequestBody Assinante assinante) {
        return service.atualizar(assinante);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


}
