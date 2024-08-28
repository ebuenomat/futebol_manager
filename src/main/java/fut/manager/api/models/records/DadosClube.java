package fut.manager.api.models.records;

import fut.manager.api.models.entities.Jogador;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record DadosClube(
        @NotBlank String nomeFantasia, @NotBlank String cnpj, LocalDate fundacao, String mascote, DadosEndereco endereco, List<Jogador> jogadores) {
}
