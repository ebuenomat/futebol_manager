package fut.manager.api.models.records;

import fut.manager.api.models.enums.Posicao;

public record DadosCadastroJogador(String nome, String email, String idade, Posicao posicao, DadosEndereco endereco) {
}
