package fut.manager.api.controller;

import fut.manager.api.models.entities.Jogador;
import fut.manager.api.models.records.DadosCadastroJogador;
import fut.manager.api.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> cadastrarJogador(@RequestBody @Valid DadosCadastroJogador dados) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.criarJogador(dados));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> listarJogadores() {
        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.listarJogadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getJogador(@PathVariable(value = "id") Long id) {
        Object jogador = jogadorService.jogador(id);
        if(((Optional<?>) jogador).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(((Optional<?>) jogador).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarJogador(@PathVariable(value = "id") Long id) {
        Optional<Jogador> jogador = jogadorService.jogador(id);
        if(jogador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador não encontrado");
        }
        jogadorService.deletarJogador(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Jogador deletado com sucesso!!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarJogador(@PathVariable(value = "id") Long id,
                                                   @RequestBody @Valid DadosCadastroJogador dados) {
        Optional<Jogador> jogador = jogadorService.jogador(id);
        if(jogador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador não encontrado");
        }
        Jogador jogadorAtualizado = jogadorService.atualizarJogador(id, dados);
        return ResponseEntity.status(HttpStatus.OK)
                .body(jogadorAtualizado);
    }
}
