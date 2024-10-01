package fut.manager.api.service;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.entities.Partida;
import fut.manager.api.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    };

    public List<Partida> listarPartidasByClube(Clube clubeCasa, Clube clubeVisitante) {
        return partidaRepository.findByClubeCasaOrClubeVisitante(clubeCasa, clubeVisitante);
    };
}
