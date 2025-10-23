package br.com.sorteio.gerador_grupos.controller;

import br.com.sorteio.gerador_grupos.model.Grupo;
import br.com.sorteio.gerador_grupos.service.SorteioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/sorteio") // Todas as URLs desta classe começarão com /api
public class SorteioController {

    @Autowired
    private SorteioService sorteioService;

    // Realizar o sorteio e salvar no banco
    // Endpoint para realizar o sorteio
    // Ex: GET http://localhost:8080/api/sorteio?grupos=3
    @GetMapping
    public ResponseEntity<List<Grupo>> realizarSorteio(@RequestParam("grupos") int numeroDeGrupos) {
        List<Grupo> gruposSorteados = sorteioService.sortear(numeroDeGrupos);
        return ResponseEntity.ok(gruposSorteados);
    }
}
