package com.truthlens.detector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectorResponse {
    private String resposta;
    private Integer score;
}
