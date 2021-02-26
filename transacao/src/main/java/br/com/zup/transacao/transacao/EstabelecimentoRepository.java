package br.com.zup.transacao.transacao;

import br.com.zup.transacao.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Optional<Estabelecimento> findByCidadeAndEnderecoAndNome(String cidade, String endereco, String nome);
}
