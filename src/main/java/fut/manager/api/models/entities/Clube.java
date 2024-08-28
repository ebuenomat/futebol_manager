package fut.manager.api.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import fut.manager.api.models.records.DadosEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Clube")
@Table(name = "clube")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    private String cnpj;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fundacao;

    private String mascote;

    @Embedded
    private DadosEndereco endereco;

    @OneToMany(mappedBy = "clube", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "jogador_id")
    private List<Jogador> jogadores;
}
