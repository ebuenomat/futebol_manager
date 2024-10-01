package fut.manager.api.controller;

import fut.manager.api.models.entities.Partida;
import fut.manager.api.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    PartidaService partidaService;

    ResponseEntity<List<Partida>> listarPartidas() {
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.listarPartidas());
    }
}
