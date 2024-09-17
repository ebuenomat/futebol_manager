package fut.manager.api.models.records;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroJogador(
        @NotBlank String nome, @NotBlank String cpf , String email, LocalDate dataNascimento,
        Integer idade, Posicao posicao, StatusJogador status, DadosEndereco endereco, Clube clube) {
}
