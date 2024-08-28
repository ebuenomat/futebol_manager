package fut.manager.api.controller;

import fut.manager.api.models.entities.Clube;
import fut.manager.api.models.records.DadosClube;
import fut.manager.api.service.ClubeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @Autowired
    ClubeService clubeService;

    @PostMapping
    public ResponseEntity<Clube> criarClube(@RequestBody @Valid DadosClube dadosClube) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeService.criarClube(dadosClube));
    }

    @GetMapping
    public ResponseEntity<List<Clube>> listarClubes() {
        return ResponseEntity.status(HttpStatus.OK).body(clubeService.listarClubes());
    }

    public ResponseEntity<Object> getClube(@PathVariable(value = "id") Long id) {
        Object clube = clubeService.clube(id);
        if(((Optional<?>) clube).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(((Optional<?>) clube).get());
    }
}
