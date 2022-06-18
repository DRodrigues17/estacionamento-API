package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1/veiculo")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService veiculoService) {
        this.service = veiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDto> findVeicleById(@PathVariable("id") Integer id) {
        Optional<VeiculoDto> optionalVeiculoDto = service.findById(id);
        if (optionalVeiculoDto.isPresent())
            return ResponseEntity.ok(optionalVeiculoDto.get());

        return ResponseEntity.notFound().build();
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
