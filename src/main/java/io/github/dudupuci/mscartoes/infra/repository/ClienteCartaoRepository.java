package io.github.dudupuci.mscartoes.infra.repository;

import io.github.dudupuci.mscartoes.domain.Cartao;
import io.github.dudupuci.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
    List<ClienteCartao> findByCpf(String cpf);
}
