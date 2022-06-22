package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.dto.VeiculoDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.FOUND)
    public VeiculoDto findById(@PathVariable("id") Integer id) {
        Optional<VeiculoDto> optionalVeiculoDto = service.findById(id);
        return optionalVeiculoDto.orElse(null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  Iterable<Veiculo> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo salvar(@RequestBody Veiculo veiculo){
        return service.salvar(veiculo);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Veiculo atualizar(@RequestBody Veiculo veiculo){
        return service.atualizar(veiculo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
