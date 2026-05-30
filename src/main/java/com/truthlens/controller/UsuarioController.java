package com.truthlens.controller;

import com.truthlens.dto.UsuarioDTO;
import com.truthlens.dto.UsuarioRequestDTO;
import com.truthlens.model.Usuario;
import com.truthlens.service.UsuarioService;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/usuarios")

@CrossOrigin(origins = "*")

public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private ModelMapper mapper;

    // GET TODOS

    @GetMapping

    public List<UsuarioDTO> listar() {

        return service.listar();
    }

    // GET POR ID

    @GetMapping("/{id}")

    public ResponseEntity<Usuario> buscarPorId(
            @PathVariable Long id
    ) {

        Optional<Usuario> usuario =
                service.buscarPorId(id);

        return usuario
                .map(ResponseEntity::ok)
                .orElse(
                        ResponseEntity.notFound().build()
                );
    }

    // POST

    @PostMapping

    @ResponseStatus(HttpStatus.CREATED)

    public UsuarioDTO salvar(
            @Valid @RequestBody UsuarioRequestDTO dto
    ) {

        Usuario usuario =
                mapper.map(dto, Usuario.class);

        return service.salvar(usuario);
    }

    // PUT

    @PutMapping("/{id}")

    public ResponseEntity<Usuario> atualizar(

            @PathVariable Long id,

            @Valid @RequestBody UsuarioRequestDTO dto
    ) {

        Usuario usuario =
                mapper.map(dto, Usuario.class);

        Usuario atualizado =
                service.atualizar(id, usuario);

        return ResponseEntity.ok(atualizado);
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