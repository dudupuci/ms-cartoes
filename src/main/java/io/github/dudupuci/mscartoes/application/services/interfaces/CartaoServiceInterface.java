package io.github.dudupuci.mscartoes.application.services.interfaces;

import io.github.dudupuci.mscartoes.domain.Cartao;

import java.util.List;
import java.util.Optional;

public interface CartaoServiceInterface {
    Cartao save(Cartao cartao);
    Optional<Cartao> findById(Long id);
    List<Cartao> findAll();
    List<Cartao> findByRendaLessThanEqual(Long renda);
}
