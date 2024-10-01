package fut.manager.api.repository;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByClubeCasaOrClubeVisitante(Clube clubeCasa, Clube clubeVisitante);

}
