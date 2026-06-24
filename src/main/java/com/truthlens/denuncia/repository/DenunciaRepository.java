package com.truthlens.denuncia.repository;

import com.truthlens.denuncia.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}