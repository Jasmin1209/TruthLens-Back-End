package com.truthlens.usuario.controller;

import com.truthlens.usuario.dto.UsuarioDTO;
import com.truthlens.usuario.dto.UsuarioRequestDTO;
import com.truthlens.usuario.model.Usuario;
import com.truthlens.usuario.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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
    public Page<UsuarioDTO> listar(
            Pageable pageable
    ){

        return service.listar(pageable);
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