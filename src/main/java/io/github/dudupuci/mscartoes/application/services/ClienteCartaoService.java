package io.github.dudupuci.mscartoes.application.services;

import io.github.dudupuci.mscartoes.application.services.interfaces.ClienteCartaoServiceInterface;
import io.github.dudupuci.mscartoes.domain.ClienteCartao;
import io.github.dudupuci.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteCartaoService implements ClienteCartaoServiceInterface {

    private final ClienteCartaoRepository repository;
    @Override
    @Transactional
    public ClienteCartao save(ClienteCartao clienteCartao) {
        return this.repository.save(clienteCartao);
    }

    @Override
    public Optional<ClienteCartao> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return this.repository.findByCpf(cpf);
    }
}
