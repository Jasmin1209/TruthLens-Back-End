package com.truthlens.detector.controller;

import com.truthlens.detector.dto.DetectorRequest;
import com.truthlens.detector.dto.DetectorResponse;

import com.truthlens.detector.service.DetectorService;

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