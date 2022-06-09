package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/assinnante")
public class AssinanteController {

    private final AssinanteService assinanteService;

    public AssinanteController(AssinanteService assinanteService) {
        this.assinanteService = assinanteService;
    }

    @GetMapping("/{id}")
    public Assinante findCityById(@PathVariable("id") Integer id){
        Optional<Assinante> optionalVeiculo = assinanteService.fingById(id);
        if (optionalVeiculo.isPresent())
            return optionalVeiculo.get();

        return null;
    }

    @GetMapping
    public  Iterable<Assinante> findAll(){
        return  assinanteService.findAll();
    }

    @PostMapping
    public Assinante salvar(@RequestBody Assinante assinante){
        return assinanteService.salvar(assinante);
    }


    @PutMapping
    public Assinante atualizar(@RequestBody Assinante assinante){
        return assinanteService.atualizar(assinante);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        assinanteService.delete(id);
    }


}
