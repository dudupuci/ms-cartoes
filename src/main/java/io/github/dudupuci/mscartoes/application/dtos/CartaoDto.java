package io.github.dudupuci.mscartoes.application.dtos;

import io.github.dudupuci.mscartoes.domain.Cartao;
import lombok.Data;

@Data
public class CartaoDto {
    private String nome;
    private String bandeira;
    private Double renda;
    private Double limite;

    public Cartao toModel() {
        return new Cartao(
                nome,
                bandeira,
                renda,
                limite
        );
    }
}
