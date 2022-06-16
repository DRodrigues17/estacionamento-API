package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
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
    public VeiculoDto findVeicleById(@PathVariable("id") Integer id) {
        Optional<VeiculoDto> optionalVeiculoDto = service.fingById(id);
        if (optionalVeiculoDto.isPresent())
            return optionalVeiculoDto.get();

        return null;
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
