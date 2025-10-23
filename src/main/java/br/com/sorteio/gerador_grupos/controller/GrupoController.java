package br.com.sorteio.gerador_grupos.controller;

import br.com.sorteio.gerador_grupos.model.Grupo;
import br.com.sorteio.gerador_grupos.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/grupos") // Todas as URLs desta classe começarão com /api
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    // Endpoint para adicionar um novo grupo
    @PostMapping
    public ResponseEntity<Grupo> adicionarGrupo(@RequestBody Grupo grupo) {
        grupoService.salvar(grupo);
        return ResponseEntity.ok(grupo);
    }

    // Endpoint para listar todos os grupos cadastrados
    @GetMapping
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.listarTodos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarPorId(@PathVariable Long id) {
        Grupo grupo = grupoService.buscarPorId(id);
        return ResponseEntity.ok(grupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> deletarGrupo(@PathVariable Long id){
        Grupo grupo = grupoService.deletar(id);
        return ResponseEntity.ok(grupo);
    }
}