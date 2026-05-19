package com.truthlens.service;

import com.truthlens.model.Denuncia;
import com.truthlens.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    public List<Denuncia> listar() {
        return repository.findAll();
    }

    public Denuncia salvar(Denuncia denuncia) {
        return repository.save(denuncia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}