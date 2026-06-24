package com.truthlens.usuario.service;

import com.truthlens.usuario.dto.UsuarioDTO;
import com.truthlens.usuario.model.Usuario;
import com.truthlens.usuario.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    // LISTAR

    public Page<UsuarioDTO> listar(Pageable pageable){

        return repository
                .findAll(pageable)
                .map(usuario ->
                        mapper.map(
                                usuario,
                                UsuarioDTO.class
                        )
                );
    }

    // BUSCAR POR ID

    public Optional<Usuario> buscarPorId(Long id) {

        return repository.findById(id);
    }

    // SALVAR
    @Transactional
    public UsuarioDTO salvar(Usuario usuario) {

        Usuario salvo = repository.save(usuario);

        return mapper.map(
                salvo,
                UsuarioDTO.class
        );
    }

    // ATUALIZAR
    @Transactional
    public Usuario atualizar(
            Long id,
            Usuario novoUsuario
    ) {

        Usuario usuario = repository
                .findById(id)
                .orElseThrow();

        usuario.setEmail(
                novoUsuario.getEmail()
        );

        usuario.setSenha(
                novoUsuario.getSenha()
        );

        return repository.save(usuario);
    }

    // DELETAR
    @Transactional
    public void deletar(Long id) {

        repository.deleteById(id);
    }
}