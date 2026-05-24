package com.truthlens.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionHandler {

    // 404

    @ExceptionHandler(
            RecursoNaoEncontradoException.class
    )

    public ResponseEntity<Map<String, Object>>
    tratarRecursoNaoEncontrado(

            RecursoNaoEncontradoException ex
    ) {

        Map<String, Object> erro =
                new HashMap<>();

        erro.put(
                "timestamp",
                LocalDateTime.now()
        );

        erro.put(
                "status",
                404
        );

        erro.put(
                "erro",
                "Recurso não encontrado"
        );

        erro.put(
                "mensagem",
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);
    }

    // 500

    @ExceptionHandler(Exception.class)

    public ResponseEntity<Map<String, Object>>
    tratarErroGeral(Exception ex) {

        Map<String, Object> erro =
                new HashMap<>();

        erro.put(
                "timestamp",
                LocalDateTime.now()
        );

        erro.put(
                "status",
                500
        );

        erro.put(
                "erro",
                "Erro interno"
        );

        erro.put(
                "mensagem",
                ex.getMessage()
        );

        return ResponseEntity
                .status(
                        HttpStatus
                                .INTERNAL_SERVER_ERROR
                )

                .body(erro);
    }
}