package fut.manager.api.models.records;

import fut.manager.api.models.enums.Posicao;
import fut.manager.api.models.enums.StatusJogador;

public record DadosCadastroJogador(String nome, String email, Integer idade, Posicao posicao, StatusJogador status, DadosEndereco endereco) {
}
