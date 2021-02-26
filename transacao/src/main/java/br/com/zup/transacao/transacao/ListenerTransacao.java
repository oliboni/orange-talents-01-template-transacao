package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {
    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void Listener(EventoTransacao eventoTransacao) {
        transacaoRepository.save(eventoTransacao.toTransacao(cartaoRepository, estabelecimentoRepository));
        System.out.println("Transação " + eventoTransacao.getId() + " salva com sucesso!");
    }
}
