package fut.manager.api.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.models.records.DadosEndereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Min(value = 11, message = "CPF deve conter 11 caracteres")
    @Max(value = 11, message = "CPF deve conter 11 caracteres")
    private String cpf;
    @Email(message = "Email deve ser válido")
    private String email;
    @JsonFormat(pattern = "dd-MM-yyyy")
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
