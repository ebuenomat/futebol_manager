package fut.manager.api.controller;

import fut.manager.api.models.entities.Jogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping
    public void cadastrarJogador(@RequestBody DadosCadastroJogador dados) {
        System.out.println(dados);
    }

    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorService.listarJogadores();
    }
}
