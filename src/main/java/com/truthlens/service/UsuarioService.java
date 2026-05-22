package com.truthlens.service;

import com.truthlens.model.Usuario;
import com.truthlens.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // LISTAR

    public List<Usuario> listar() {

        return repository.findAll();
    }

    // BUSCAR POR ID

    public Optional<Usuario> buscarPorId(Long id) {

        return repository.findById(id);
    }

    // SALVAR

    public Usuario salvar(Usuario usuario) {

        return repository.save(usuario);
    }

    // ATUALIZAR

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

    public void deletar(Long id) {

        repository.deleteById(id);
    }
}