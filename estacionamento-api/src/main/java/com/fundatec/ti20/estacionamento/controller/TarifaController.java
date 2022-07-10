package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.service.TarifaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/veliculos")
public class TarifaController {
    @Autowired
    private final TarifaService service;

//    @GetMapping("/{idVeiculo}/contas/{idConta}/tarifas")
//    @ResponseStatus(HttpStatus.FOUND)
//    public ResponseEntity<Tarifa> findTarifa(@PathVariable Integer idVeiculo, @PathVariable Integer idConta) {
//        Tarifa tarifa = service.find(idVeiculo, idConta);
//        return ResponseEntity.ok(tarifa);
//    }


}
