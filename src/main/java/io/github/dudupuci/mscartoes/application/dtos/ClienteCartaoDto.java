package io.github.dudupuci.mscartoes.application.dtos;

import io.github.dudupuci.mscartoes.domain.ClienteCartao;
import io.github.dudupuci.mscartoes.domain.enums.BandeiraCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCartaoDto {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal limite;

    public static ClienteCartaoDto from(ClienteCartao model) {
        return new ClienteCartaoDto(
                model.getCartao().getNome(),
                model.getCartao().getBandeira(),
                model.getLimite()
        );
    }
}
