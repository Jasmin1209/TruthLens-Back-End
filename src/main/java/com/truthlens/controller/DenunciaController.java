package com.truthlens.controller;

import com.truthlens.dto.DenunciaDTO;
import com.truthlens.model.Denuncia;
import com.truthlens.service.DenunciaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/denuncias")

@CrossOrigin(origins = "*")

public class DenunciaController {

    @Autowired
    private DenunciaService service;

    // GET - LISTAR

    @GetMapping

    public List<DenunciaDTO> listar() {

        return service.listar();
    }

    // POST

    @PostMapping

    @ResponseStatus(HttpStatus.CREATED)

    public DenunciaDTO salvar(
            @RequestBody Denuncia denuncia
    ) {

        return service.salvar(denuncia);
    }

    // PUT

    @PutMapping("/{id}")

    public ResponseEntity<Denuncia> atualizar(

            @PathVariable Long id,

            @RequestBody Denuncia denuncia
    ) {

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