package com.truthlens.controller;

import com.truthlens.dto.DenunciaDTO;
import com.truthlens.dto.DenunciaRequestDTO;
import com.truthlens.model.Denuncia;
import com.truthlens.service.DenunciaService;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/denuncias")

@CrossOrigin(origins = "*")

public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @Autowired
    private ModelMapper mapper;

    // GET

    @GetMapping
    public Page<DenunciaDTO> listar(
            Pageable pageable
    ){

        return service.listar(pageable);
    }

    // POST

    @PostMapping

    @ResponseStatus(HttpStatus.CREATED)

    public DenunciaDTO salvar(
            @Valid @RequestBody DenunciaRequestDTO dto
    ) {

        Denuncia denuncia =
                mapper.map(dto, Denuncia.class);

        return service.salvar(denuncia);
    }

    // PUT

    @PutMapping("/{id}")

    public ResponseEntity<Denuncia> atualizar(

            @PathVariable Long id,

            @Valid @RequestBody DenunciaRequestDTO dto
    ) {

        Denuncia denuncia =
                mapper.map(dto, Denuncia.class);

        Denuncia atualizada =
                service.atualizar(id, denuncia);

        return ResponseEntity.ok(atualizada);
    }

    // DELETE

    @DeleteMapping("/{id}")

    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deletar(
            @PathVariable Long id
    ) {

        service.deletar(id);
    }
}