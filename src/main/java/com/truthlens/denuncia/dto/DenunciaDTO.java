package com.truthlens.denuncia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DenunciaDTO {
    private Long id;

    private String titulo;

    private String descricao;
}
