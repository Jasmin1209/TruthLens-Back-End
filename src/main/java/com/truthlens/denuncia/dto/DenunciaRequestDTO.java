package com.truthlens.denuncia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DenunciaRequestDTO {

    @NotBlank(message = "Título obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição obrigatória")
    private String descricao;
}