package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.service.TarifaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/tarifa")
public class TarifaController {

    private final TarifaService tarifaService;

    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @GetMapping("/{id}")
    public Tarifa findCityById(@PathVariable("id") Integer id){
        Optional<Tarifa> optionalTarifa = tarifaService.fingById(id);
        if (optionalTarifa.isPresent())
            return optionalTarifa.get();

        return null;
    }

    @GetMapping
    public  Iterable<Tarifa> findAll(){
        return  tarifaService.findAll();
    }

    @PostMapping
    public Tarifa salvar(@RequestBody Tarifa tarifa){
        return tarifaService.salvar(tarifa);
    }


    @PutMapping
    public Tarifa atualizar(@RequestBody Tarifa tarifa){
        return tarifaService.atualizar(tarifa);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        tarifaService.delete(id);
    }

}
