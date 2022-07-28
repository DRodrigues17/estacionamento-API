package com.fundatec.ti20.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<ApiErrorDTO> ConflictHandler(ConflitoException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodNotAllowed(NotAllowedException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> NotFoundHandler(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> ErroDesconhecidoHandler(Throwable e) {
        return new ResponseEntity<>(new ApiErrorDTO("não temos uma excessão para isso ainda",
                LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
}
