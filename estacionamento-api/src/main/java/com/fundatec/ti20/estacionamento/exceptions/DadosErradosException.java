package com.fundatec.ti20.estacionamento.exceptions;

public class DadosErradosException extends RuntimeException {

    public DadosErradosException(String message) {
        super("INFORMAÇÕES ERRADOAS, POR FAVOR REVEJA ELAS E TENTE NOVAMENTE" + message);
    }

    public DadosErradosException(String message, Throwable cause) {
        super(message, cause);
    }
}
