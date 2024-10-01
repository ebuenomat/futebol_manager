package fut.manager.api.models.entities;

import fut.manager.api.models.records.DadosPartida;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clube_casa_id")
    private Clube clubeCasa;

    @ManyToOne
    @JoinColumn(name = "clube_visitante_id")
    private Clube clubeVisitante;

    private Integer golsCasa;
    private Integer golsVisitante;
    private LocalDate dataPartida;

    public Partida(DadosPartida dadosPartida) {
        this.clubeCasa = dadosPartida.clubeCasa();
        this.clubeVisitante = dadosPartida.clubeVisitante();
        this.golsCasa = dadosPartida.golsCasa();
        this.golsVisitante = dadosPartida.golsVisitante();
        this.dataPartida = dadosPartida.dataPartida();
    }
}
