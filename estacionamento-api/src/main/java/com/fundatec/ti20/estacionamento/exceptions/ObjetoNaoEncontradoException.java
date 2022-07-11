package com.fundatec.ti20.estacionamento.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super("objeto não encontrado, favor rever as informações e tentar novamente" + message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
