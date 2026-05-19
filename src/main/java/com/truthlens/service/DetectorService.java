package com.truthlens.service;

import org.springframework.stereotype.Service;

@Service
public class DetectorService {

    public String analisar(String texto) {

        texto = texto.toLowerCase();

        int score = 0;

        if(texto.contains("urgente")) {
            score++;
        }

        if(texto.contains("100% garantido")) {
            score++;
        }

        if(texto.contains("milagre")) {
            score++;
        }

        if(score >= 2) {
            return "Alta chance de fake news";
        }

        return "Conteúdo aparentemente confiável";
    }
}
