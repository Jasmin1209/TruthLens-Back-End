package com.truthlens.controller;

import com.truthlens.dto.DetectorRequest;
import com.truthlens.dto.DetectorResponse;

import com.truthlens.service.DetectorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/detector")

@CrossOrigin(origins = "*")

public class DetectorController {

    @Autowired
    private DetectorService service;

    @PostMapping

    public DetectorResponse analisar(

            @RequestBody DetectorRequest request
    ) {

        int score =
                service.calcularScore(
                        request.getTexto()
                );

        String resultado =
                service.gerarResultado(score);

        return new DetectorResponse(
                resultado,
                score
        );
    }
}