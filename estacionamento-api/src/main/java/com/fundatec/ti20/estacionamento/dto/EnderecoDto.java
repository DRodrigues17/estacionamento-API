package com.fundatec.ti20.estacionamento.dto;

import com.fundatec.ti20.estacionamento.model.Endereco;


public class EnderecoDto {

    private String logradouro;
    private String cep;

    public EnderecoDto() {
    }

    public EnderecoDto(Endereco endereco) {
        logradouro = endereco.getLogradouro();
        cep = endereco.getCep();
    }

    public EnderecoDto(String endereco, String cep) {
        this.logradouro = endereco;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

}
