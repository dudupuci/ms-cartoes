package io.github.dudupuci.mscartoes.domain;

import io.github.dudupuci.mscartoes.application.dtos.CartaoDto;
import io.github.dudupuci.mscartoes.domain.enums.BandeiraCartao;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao() {
    }

    public Cartao(
            Long id,
            String nome,
            BandeiraCartao bandeira,
            BigDecimal renda,
            BigDecimal limite
    ) {
        this.id = id;
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limite = limite;
    }

    public CartaoDto toDto() {
        return new CartaoDto(
                id,
                nome,
                bandeira,
                renda,
                limite
        );
    }
}
