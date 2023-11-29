package io.github.dudupuci.mscartoes.application.services.interfaces;

import io.github.dudupuci.mscartoes.domain.ClienteCartao;

import java.util.List;
import java.util.Optional;

public interface ClienteCartaoServiceInterface {
    ClienteCartao save(ClienteCartao clienteCartao);

    Optional<ClienteCartao> findById(Long id);

    List<ClienteCartao> listCartoesByCpf(String cpf);
}
