package fut.manager.api.models.entities;

import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.models.records.DadosEndereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    private String cpf;
    private String email;

    private LocalDate dataNascimento;
    private Integer idade;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @Enumerated(EnumType.STRING)
    private StatusJogador status;
    @Embedded
    private DadosEndereco endereco;

    @ManyToOne
    @JoinColumn(name = "clube_id")
    private Clube clube;

    public Jogador(DadosCadastroJogador cadastroJogador) {
        this.nome = cadastroJogador.nome();
        this.cpf = cadastroJogador.cpf();
        this.email = cadastroJogador.email();
        this.dataNascimento = cadastroJogador.dataNascimento();
        this.idade = cadastroJogador.idade();
        this.posicao = cadastroJogador.posicao();
        this.status = cadastroJogador.status();
        this.endereco = new DadosEndereco(cadastroJogador.endereco());
        this.clube = cadastroJogador.clube();
    }


}
