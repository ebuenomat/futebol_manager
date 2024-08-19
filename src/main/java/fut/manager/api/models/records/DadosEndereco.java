package fut.manager.api.models.records;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//public record DadosEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String numero, String complemento) {
//
////    public DadosEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String numero, String complemento) {
////       this(logradouro, bairro, cep, cidade, uf, numero, complemento);
////    }
//
//}
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosEndereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public DadosEndereco(DadosEndereco endereco) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
    }
}