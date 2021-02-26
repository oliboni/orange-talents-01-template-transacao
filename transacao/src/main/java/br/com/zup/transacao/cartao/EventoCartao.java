package br.com.zup.transacao.cartao;

import java.util.Optional;

public class EventoCartao {
    private String id;
    private String email;

    @Deprecated
    public EventoCartao() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toCartao(CartaoRepository cartaoRepository){
        Optional<Cartao> cartao = cartaoRepository.findByIdCartao(id);
        if(cartao.isPresent()){
            return cartao.get();
        }
        Cartao novoCartao = new Cartao(id,email);
        cartaoRepository.save(novoCartao);
        return novoCartao;
    }
}
