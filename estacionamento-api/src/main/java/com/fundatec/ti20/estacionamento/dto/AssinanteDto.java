package com.fundatec.ti20.estacionamento.dto;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;

import java.util.List;

@Builder
public class AssinanteDto {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<Veiculo> veiculos;

    public AssinanteDto() {
    }

    public AssinanteDto(Assinante assinante) {
        nome = assinante.getNome();
        cpf = assinante.getCpf();
        endereco = assinante.getEndereco();
        veiculos = assinante.getVeiculos();
    }

    public AssinanteDto(String nome, String cpf, Endereco endereco, List<Veiculo> veiculos) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.veiculos = veiculos;
    }
}
