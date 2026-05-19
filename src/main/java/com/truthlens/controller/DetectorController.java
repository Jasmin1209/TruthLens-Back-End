package com.truthlens.controller;

import com.truthlens.dto.DetectorRequest;
import com.truthlens.dto.DetectorResponse;
import com.truthlens.service.DetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detector")
public class DetectorController {

    @Autowired
    private DetectorService service;

    @PostMapping
    public DetectorResponse analisar(
            @RequestBody DetectorRequest request
    ) {

        String resultado =
                service.analisar(request.getTexto());

        return new DetectorResponse(resultado);
    }
}