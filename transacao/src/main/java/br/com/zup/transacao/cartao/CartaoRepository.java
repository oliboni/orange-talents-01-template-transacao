package br.com.zup.transacao.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    Optional<Cartao> findByIdCartao(String idCartao);
}
