package com.truthlens.service;

import org.springframework.stereotype.Service;

@Service
public class DetectorService {

    public int calcularScore(String texto) {

        texto = texto.toLowerCase();

        int score = 0;

        if(texto.contains("urgente")) {
            score++;
        }

        if(texto.contains("milagre")) {
            score++;
        }

        if(texto.contains("100% garantido")) {
            score++;
        }

        return score;
    }

    public String gerarResultado(int score) {

        if(score >= 2) {

            return "Alta chance de fake news";
        }

        return "Conteúdo aparentemente confiável";
    }
}