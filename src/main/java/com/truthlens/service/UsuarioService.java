package com.truthlens.service;

import com.truthlens.dto.UsuarioDTO;
import com.truthlens.model.Usuario;
import com.truthlens.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    // LISTAR

    public List<UsuarioDTO> listar() {

        List<Usuario> usuarios =
                repository.findAll();

        return usuarios.stream()

                .map(usuario ->
                        mapper.map(
                                usuario,
                                UsuarioDTO.class
                        )
                )

                .collect(Collectors.toList());
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