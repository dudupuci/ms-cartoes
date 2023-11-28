package io.github.dudupuci.mscartoes.infra.repository;

import io.github.dudupuci.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByRendaLessThanEqual(Double renda);
}
