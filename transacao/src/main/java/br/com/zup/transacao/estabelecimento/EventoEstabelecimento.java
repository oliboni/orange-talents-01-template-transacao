package br.com.zup.transacao.estabelecimento;

import br.com.zup.transacao.transacao.EstabelecimentoRepository;

import java.util.Optional;

public class EventoEstabelecimento {
    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EventoEstabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toEstabelecimento(EstabelecimentoRepository estabelecimentoRepository){
        Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findByCidadeAndEnderecoAndNome(cidade,endereco,nome);
        if (estabelecimento.isPresent()){
            return estabelecimento.get();
        }
        Estabelecimento novoEstabelecimento = new Estabelecimento(nome,cidade,endereco);
        estabelecimentoRepository.save(novoEstabelecimento);
        return novoEstabelecimento;
    }
}
