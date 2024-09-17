package fut.manager.api.service;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.entities.Jogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.repository.ClubeRepository;
import fut.manager.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;
    @Autowired
    ClubeRepository clubeRepository;

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

        Optional<Clube> clubeOptional = clubeRepository.findById(cadastroJogador.clube().getId());

        if (clubeOptional.isEmpty()) {
            throw new RuntimeException("Clube não encontrado.");
        }

       Jogador player = new Jogador();
           player.setNome(cadastroJogador.nome());
           player.setCpf(cadastroJogador.cpf());
           player.setDataNascimento(cadastroJogador.dataNascimento());
           player.setIdade(cadastroJogador.idade());
           player.setEmail(cadastroJogador.email());
           player.setPosicao(cadastroJogador.posicao());
           player.setStatus(cadastroJogador.status());
           player.setEndereco(cadastroJogador.endereco());
           player.setClube(clubeOptional.get());
           player.setClube(cadastroJogador.clube());

       return jogadorRepository.save(player);

    }

    public Jogador atualizarJogador(Long id, DadosCadastroJogador cadastroJogador) {
        Optional<Jogador> jogadorExistente = jogadorRepository.findById(id);

        if (jogadorExistente.isPresent()) {
            Jogador jogador = jogadorExistente.get();

            jogador.setNome(cadastroJogador.nome());
            jogador.setCpf(cadastroJogador.cpf());
            jogador.setEmail(cadastroJogador.email());
            jogador.setDataNascimento(cadastroJogador.dataNascimento());
            jogador.setIdade(cadastroJogador.idade());
            jogador.setPosicao(cadastroJogador.posicao());
            jogador.setStatus(cadastroJogador.status());
            jogador.setEndereco(cadastroJogador.endereco());
            jogador.setClube(cadastroJogador.clube());

            return jogadorRepository.save(jogador);
        } else {
            throw new RuntimeException("Jogador não encontrado.");
        }
    }
}
