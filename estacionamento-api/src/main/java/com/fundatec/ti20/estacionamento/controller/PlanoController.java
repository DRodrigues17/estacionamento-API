package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.model.Plano;
import com.fundatec.ti20.estacionamento.service.PlanoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/plano")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping("/{id}")
    public Plano findCityById(@PathVariable("id") Integer id){
        Optional<Plano> optionalPlano = planoService.fingById(id);
        if (optionalPlano.isPresent())
            return optionalPlano.get();

        return null;
    }

    @GetMapping
    public  Iterable<Plano> findAll(){
        return  planoService.findAll();
    }

    @PostMapping
    public Plano salvar(@RequestBody Plano plano){
        return planoService.salvar(plano);
    }


    @PutMapping
    public Plano atualizar(@RequestBody Plano plano){
        return planoService.atualizar(plano);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        planoService.delete(id);
    }

}
