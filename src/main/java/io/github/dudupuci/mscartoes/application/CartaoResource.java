package io.github.dudupuci.mscartoes.application;

import io.github.dudupuci.mscartoes.application.dtos.CartaoDto;
import io.github.dudupuci.mscartoes.application.dtos.ClienteCartaoDto;
import io.github.dudupuci.mscartoes.application.dtos.ClienteCartaoSaveRequest;
import io.github.dudupuci.mscartoes.application.services.CartaoService;
import io.github.dudupuci.mscartoes.application.services.ClienteCartaoService;
import io.github.dudupuci.mscartoes.domain.Cartao;
import io.github.dudupuci.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
@Slf4j
public class CartaoResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoDto dto) {
        var cartao = this.cartaoService.save(dto.toModel());

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(cartao.getId())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoDto>> getCartoesRendaAte(@RequestParam("renda") Long renda) {
        var cartoes = this.cartaoService.findByRendaLessThanEqual(renda);

        return ResponseEntity.ok(cartoes
                .stream()
                .map(Cartao::toDto)
                .collect(Collectors.toList()));
    }


    @PostMapping("/cliente/cartao")
    public ResponseEntity<ClienteCartaoDto> criarClienteCartao(@RequestBody ClienteCartaoSaveRequest dto) {
        var cartao = this.cartaoService.findById(dto.getCartaoId());

        if (cartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var clienteCartao = new ClienteCartao(
                dto.getCpf(),
                cartao.get(),
                dto.getLimite()
        );

        this.clienteCartaoService.save(clienteCartao);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(clienteCartao.getId())
                .toUri();

        return ResponseEntity.created(headerLocation).body(ClienteCartaoDto.from(clienteCartao));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClienteCartaoDto>> getCartoesByCpf(@RequestParam("cpf") String cpf) {
        var clienteCartoes = clienteCartaoService.listCartoesByCpf(cpf);
        return ResponseEntity.ok(clienteCartoes.stream().map(ClienteCartaoDto::from).collect(Collectors.toList()));
    }
}
