package fut.manager.api.models.records;

import fut.manager.api.models.entities.Clube;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosPartida(
        Long id, @NotBlank Clube clubeCasa, @NotBlank Clube clubeVisitante, Integer golsCasa, Integer golsVisitante, LocalDate dataPartida
    ) {
}
