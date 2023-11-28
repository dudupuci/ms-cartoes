package io.github.dudupuci.mscartoes.services;

import io.github.dudupuci.mscartoes.domain.Cartao;
import io.github.dudupuci.mscartoes.infra.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartaoService implements CartaoServiceInterface {

    private final CartaoRepository repository;

    public CartaoService(CartaoRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    @Transactional
    public Cartao save(Cartao cartao) {
        return this.repository.save(cartao);
    }

    @Override
    public Optional<Cartao> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Cartao> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Cartao> findByRendaLessThanEqual(Double renda) {
        return this.repository.findByRendaLessThanEqual(renda);
    }
}
