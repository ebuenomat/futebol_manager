package fut.manager.api.models.entities;

import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.models.records.DadosEndereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Jogador")
@Table(name = "jogador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @Enumerated(EnumType.STRING)
    private StatusJogador status;
    @Embedded
    private DadosEndereco endereco;

    public Jogador(DadosCadastroJogador cadastroJogador) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.posicao = posicao;
        this.status = status;
        this.endereco = new DadosEndereco(cadastroJogador.endereco());
    }


}
