package com.truthlens.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionHandler {

    // =========================================
    // 404 - RECURSO NÃO ENCONTRADO
    // =========================================

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
                HttpStatus.NOT_FOUND.value()
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

    // =========================================
    // 400 - ERRO DE VALIDAÇÃO
    // =========================================

    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )

    public ResponseEntity<Map<String, Object>>
    tratarValidacao(

            MethodArgumentNotValidException ex
    ) {

        Map<String, String> campos =
                new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(erro -> {

                    campos.put(
                            erro.getField(),
                            erro.getDefaultMessage()
                    );
                });

        Map<String, Object> resposta =
                new HashMap<>();

        resposta.put(
                "timestamp",
                LocalDateTime.now()
        );

        resposta.put(
                "status",
                HttpStatus.BAD_REQUEST.value()
        );

        resposta.put(
                "erro",
                "Erro de validação"
        );

        resposta.put(
                "campos",
                campos
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }

    // =========================================
    // 500 - ERRO INTERNO
    // =========================================

    @ExceptionHandler(Exception.class)

    public ResponseEntity<Map<String, Object>>
    tratarErroGeral(

            Exception ex
    ) {

        Map<String, Object> erro =
                new HashMap<>();

        erro.put(
                "timestamp",
                LocalDateTime.now()
        );

        erro.put(
                "status",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        erro.put(
                "erro",
                "Erro interno do servidor"
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