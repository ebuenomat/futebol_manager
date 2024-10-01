package fut.manager.api.models.entities;

import jakarta.persistence.*;

@Entity
public class Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clube_id")
    private Clube clube;

    private Integer pontos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
}
