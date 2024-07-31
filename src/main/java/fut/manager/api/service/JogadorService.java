package fut.manager.api.service;

import fut.manager.api.models.entities.Jogador;
import fut.manager.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }
}
