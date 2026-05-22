package com.truthlens.service;

import com.truthlens.model.Denuncia;
import com.truthlens.repository.DenunciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    // LISTAR

    public List<Denuncia> listar() {

        return repository.findAll();
    }

    // BUSCAR POR ID

    public Optional<Denuncia> buscarPorId(Long id) {

        return repository.findById(id);
    }

    // SALVAR

    public Denuncia salvar(Denuncia denuncia) {

        return repository.save(denuncia);
    }

    // ATUALIZAR

    public Denuncia atualizar(
            Long id,
            Denuncia novaDenuncia
    ) {

        Denuncia denuncia = repository
                .findById(id)
                .orElseThrow();

        denuncia.setTitulo(
                novaDenuncia.getTitulo()
        );

        denuncia.setDescricao(
                novaDenuncia.getDescricao()
        );

        return repository.save(denuncia);
    }

    // DELETAR

    public void deletar(Long id) {

        repository.deleteById(id);
    }
}