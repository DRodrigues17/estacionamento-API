package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.AssinanteDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.FOUND)
    public AssinanteDto findById(@PathVariable("id") Integer id) {
        Optional<AssinanteDto> optionalAssinanteDto = service.fingById(id);
        return optionalAssinanteDto.orElse(null);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<Assinante> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Assinante salvar(@RequestBody Assinante assinante) {
        return service.salvar(assinante);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Assinante atualizar(@RequestBody Assinante assinante) {
        ResponseEntity.ok().body("tudo certo, um assinante novo adicionado ao sistema");
        return service.atualizar(assinante);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


}
