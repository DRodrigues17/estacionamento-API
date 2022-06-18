package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/assinante")
public class AssinanteController {

    @Autowired
    private final AssinanteService service;

    public AssinanteController(AssinanteService assinanteService) {
        this.service = assinanteService;
    }

    @GetMapping("/{id}")
    public AssinanteDto findAssinanteById(@PathVariable Integer id) {
        Optional<AssinanteDto> optionalAssinanteDto = service.fingById(id);
        if (optionalAssinanteDto.isPresent()) {
            return optionalAssinanteDto.get();
        }

        return null;
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
