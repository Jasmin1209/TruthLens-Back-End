package com.truthlens.service;

import com.truthlens.dto.DenunciaDTO;
import com.truthlens.exception.RecursoNaoEncontradoException;
import com.truthlens.model.Denuncia;
import com.truthlens.repository.DenunciaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    @Autowired
    private ModelMapper mapper;

    // LISTAR

    public Page<DenunciaDTO> listar(Pageable pageable){

        return repository
                .findAll(pageable)
                .map(denuncia ->
                        mapper.map(
                                denuncia,
                                DenunciaDTO.class
                        )
                );
    }

    // BUSCAR POR ID

    public Denuncia buscarPorId(Long id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new RecursoNaoEncontradoException(
                                "Denúncia não encontrada"
                        )
                );
    }

    // SALVAR
    @Transactional
    public DenunciaDTO salvar(
            Denuncia denuncia
    ) {

        Denuncia salva =
                repository.save(denuncia);

        return mapper.map(
                salva,
                DenunciaDTO.class
        );
    }

    // ATUALIZAR
    @Transactional
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
    @Transactional
    public void deletar(Long id) {

        repository.deleteById(id);
    }
}