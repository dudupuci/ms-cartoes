package io.github.dudupuci.mscartoes.application.dtos;

import io.github.dudupuci.mscartoes.domain.Cartao;
import io.github.dudupuci.mscartoes.domain.enums.BandeiraCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDto {
    private Long id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel() {
        return new Cartao(
                id,
                nome,
                bandeira,
                renda,
                limite
        );
    }
}
