package com.fundatec.ti20.estacionamento.dto;

import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class AssinanteDto {

    private String nome;
    private String cpf;
    private Endereco endereco;

    private BigDecimal creditoTotal;
    private List<Veiculo> veiculos;

    public AssinanteDto() {
    }

    public AssinanteDto(Assinante assinante) {
        nome = assinante.getNome();
        cpf = assinante.getCpf();
        endereco = assinante.getEndereco();
        creditoTotal = assinante.getCreditoTotal();
        veiculos = assinante.getVeiculos();
    }

    public AssinanteDto(String nome, String cpf, Endereco endereco,BigDecimal creditoTotal, List<Veiculo> veiculos) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.creditoTotal = creditoTotal;
        this.veiculos = veiculos;
    }
}
