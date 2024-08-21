package fut.manager.api.service;

import fut.manager.api.models.entities.Jogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> jogador(Long id) {
        return jogadorRepository.findById(id);
    }

    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }

    public Jogador criarJogador(DadosCadastroJogador cadastroJogador) {
       Jogador player = new Jogador();
       player.setNome(cadastroJogador.nome());
       player.setIdade(cadastroJogador.idade());
       player.setEmail(cadastroJogador.email());
       player.setPosicao(cadastroJogador.posicao());
       player.setStatus(cadastroJogador.status());
       player.setEndereco(cadastroJogador.endereco());


       return jogadorRepository.save(player);
    }
}
