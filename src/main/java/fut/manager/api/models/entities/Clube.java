package fut.manager.api.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import fut.manager.api.models.records.DadosClube;
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

    @Column(nullable = false)
    private String nomeFantasia;

    private String cnpj;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fundacao;

    private String mascote;

    @Embedded
    private DadosEndereco endereco;

    @OneToMany(mappedBy = "clube", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jogador> jogadores;

    public Clube(DadosClube dadosClube) {
        this.nomeFantasia = dadosClube.nomeFantasia();
        this.cnpj = dadosClube.cnpj();
        this.fundacao = dadosClube.fundacao();
        this.mascote = dadosClube.mascote();
        this.endereco = new DadosEndereco(dadosClube.endereco());
        this.jogadores = dadosClube.jogadores();
    }

    public Long getId() {
        return id;
    }
}
