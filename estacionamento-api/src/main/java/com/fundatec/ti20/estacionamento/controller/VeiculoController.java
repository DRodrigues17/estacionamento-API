package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.response.VeiculoConverterImpl;
import com.fundatec.ti20.estacionamento.dto.request.VeiculoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/v1/veiculo")
public class VeiculoController {

    @Autowired
    private final VeiculoService service;
    @Autowired
    private final VeiculoConverterImpl converter;

    public VeiculoController(VeiculoService veiculoService, VeiculoConverterImpl converter) {
        this.service = veiculoService;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<VeiculoResponseDto> findVeicleById(@PathVariable("id") Integer id) {
        Veiculo veiculo = service.findById(id);
        return ResponseEntity.ok(converter.convert(veiculo));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<VeiculoResponseDto>> findAll() {
        Iterable<Veiculo> veiculo = service.findAll();
        List<VeiculoResponseDto> veiculoResponseDto = StreamSupport.stream(veiculo.spliterator(), false)
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(veiculoResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VeiculoResponseDto> salvar(@RequestBody VeiculoRequestDto veiculoRequestDto) {
        Veiculo veiculo = service.salvar(converter.convert(veiculoRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(veiculo));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VeiculoResponseDto> atualizar(@RequestBody VeiculoRequestDto veiculoRequestDto) {
        Veiculo veiculo = service.salvar(converter.convert(veiculoRequestDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(veiculo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
