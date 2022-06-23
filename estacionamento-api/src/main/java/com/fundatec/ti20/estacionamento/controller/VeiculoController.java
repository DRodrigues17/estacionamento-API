package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.VeiculoResponseConverter;
import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/veiculo")
public class VeiculoController {

    @Autowired
    private final VeiculoService service;
    @Autowired
    private final VeiculoResponseConverter converter;

    public VeiculoController(VeiculoService veiculoService, VeiculoResponseConverter converter) {
        this.service = veiculoService;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDto> findVeicleById(@PathVariable("id") Integer id) {
        Veiculo veiculo = service.findById(id);
        return ResponseEntity.ok(converter.convert(veiculo));
    }

    @GetMapping
    public  Iterable<Veiculo> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo){
        return service.salvar(veiculo);
    }


    @PutMapping
    public Veiculo atualizar(@RequestBody Veiculo veiculo){
        return service.atualizar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
