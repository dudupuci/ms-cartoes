package io.github.dudupuci.mscartoes.infra.mqueues;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    @RabbitListener(queues = "${mq.queues.emissao-cartao}")
    void receberSolicitacaoEmissaoCartao(@Payload String payload) {
        System.out.println(payload);
    }
}
