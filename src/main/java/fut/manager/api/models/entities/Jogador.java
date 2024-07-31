package fut.manager.api.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
