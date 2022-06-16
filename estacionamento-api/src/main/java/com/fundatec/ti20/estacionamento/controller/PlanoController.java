package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.PlanoDto;
import com.fundatec.ti20.estacionamento.model.Plano;
import com.fundatec.ti20.estacionamento.service.PlanoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/plano")
public class PlanoController {

    private final PlanoService service;

    public PlanoController(PlanoService planoService) {
        this.service = planoService;
    }

    @GetMapping("/{id}")
    public PlanoDto findPlanoById(@PathVariable("id") Integer id) {
        Optional<PlanoDto> optionalPlanoDto = service.fingById(id);
        if (optionalPlanoDto.isPresent())
            return optionalPlanoDto.get();

        return null;
    }

    @GetMapping
    public  Iterable<Plano> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Plano salvar(@RequestBody Plano plano){
        return service.salvar(plano);
    }


    @PutMapping
    public Plano atualizar(@RequestBody Plano plano){
        return service.atualizar(plano);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
