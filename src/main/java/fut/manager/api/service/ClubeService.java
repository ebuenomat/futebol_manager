package fut.manager.api.service;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.entities.Jogador;
import fut.manager.api.models.records.DadosClube;
import fut.manager.api.repository.ClubeRepository;
import fut.manager.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {

    @Autowired
    ClubeRepository clubeRepository;
    @Autowired
    JogadorRepository jogadorRepository;

    public List<Clube> listarClubes() {
        return clubeRepository.findAll();
    }

    public Optional<Clube> clube(Long id) {
        return clubeRepository.findById(id);
    }

    public void deletarClube(Long id) {
        clubeRepository.deleteById(id);
    }

    public Clube criarClube(DadosClube dadosClube) {
        Clube clube = new Clube();
        clube.setNomeFantasia(dadosClube.nomeFantasia());
        clube.setCnpj(dadosClube.cnpj());
        clube.setFundacao(dadosClube.fundacao());
        clube.setMascote(dadosClube.mascote());
        clube.setEndereco(dadosClube.endereco());
        clube.setJogadores(dadosClube.jogadores());

        return clubeRepository.save(clube);
    }

    public Clube atualizarClube(Long id, DadosClube dadosClube) {
        Optional<Clube> clubeExistente = clubeRepository.findById(id);

        if(clubeExistente.isPresent()) {
            Clube clube = clubeExistente.get();

            clube.setNomeFantasia(dadosClube.nomeFantasia());
            clube.setCnpj(dadosClube.cnpj());
            clube.setFundacao(dadosClube.fundacao());
            clube.setMascote(dadosClube.mascote());
            clube.setEndereco(dadosClube.endereco());
            clube.setJogadores(dadosClube.jogadores());

            return clubeRepository.save(clube);
        } else {
            throw new RuntimeException("Clube não encontrado.");
        }
    }
}
