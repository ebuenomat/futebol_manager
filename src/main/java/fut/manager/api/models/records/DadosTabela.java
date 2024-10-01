package fut.manager.api.models.records;

import fut.manager.api.models.entities.Clube;

public record DadosTabela(
        Long id, Clube clube, Integer pontos, Integer vitorias, Integer empates, Integer derrotas
    ) {
}
