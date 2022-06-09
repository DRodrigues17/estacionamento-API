package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    public Veiculo findCityById(@PathVariable("id") Integer id){
        Optional<Veiculo> optionalVeiculo = veiculoService.fingById(id);
        if (optionalVeiculo.isPresent())
            return optionalVeiculo.get();

        return null;
    }

//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Sucesso na busca"),
//            @ApiResponse(responseCode = "403", description = "Erro de permissao"),
//            @ApiResponse(responseCode = "500", description = "Erro de infraestrutura"),
//    })
//    @Parameters(
//            value = {
//                    @Parameter(name = "xxxxxxß")
//            }
//    )

    @GetMapping
    public  Iterable<Veiculo> findAll(){
        return  veiculoService.findAll();
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo){
        return veiculoService.salvar(veiculo);
    }


    @PutMapping
    public Veiculo atualizar(@RequestBody Veiculo veiculo){
        return veiculoService.atualizar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        veiculoService.delete(id);
    }
//
//    @GetMapping("/")
//    public Cidade findByLike(@RequestParam("name") String nome){
//        Optional<Cidade> optionalCity = cidadeService.findByLike(nome);
//        if (optionalCity.isPresent())
//            return optionalCity.get();
//
//        return null;
//    }

}
