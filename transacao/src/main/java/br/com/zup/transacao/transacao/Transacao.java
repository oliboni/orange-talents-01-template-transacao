package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idTransacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cartao cartao;

    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    public Transacao(String idTransacao, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        Assert.isTrue(idTransacao!=null,"O id da transão não pode ser nulo!");
        Assert.isTrue(valor!=null,"O valor não pode ser nulo!");
        Assert.isTrue(efetivadaEm!=null,"A data efetivadaEm não pode ser nulo!");
        Assert.notNull(estabelecimento,"O estabelecimento não pode ser nulo!");
        Assert.notNull(cartao,"O cartao não pode ser nulo!");
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
