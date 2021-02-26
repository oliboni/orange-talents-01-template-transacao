package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.cartao.EventoCartao;
import br.com.zup.transacao.estabelecimento.EventoEstabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoTransacao {
    private String id;
    private BigDecimal valor;
    private EventoEstabelecimento estabelecimento;
    private EventoCartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoTransacao() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toTransacao(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository){
        return new  Transacao(id,
                              valor,
                              estabelecimento.toEstabelecimento(estabelecimentoRepository),
                              cartao.toCartao(cartaoRepository),
                              efetivadaEm);
    }

}
