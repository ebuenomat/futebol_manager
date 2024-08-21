package fut.manager.api.models.records;

import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroJogador(
        @NotBlank String nome, String email, Integer idade, Posicao posicao, StatusJogador status, DadosEndereco endereco) {
}
