package br.com.sorteio.gerador_grupos.controller;

import br.com.sorteio.gerador_grupos.model.Aluno;
import br.com.sorteio.gerador_grupos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/alunos") // Todas as URLs desta classe começarão com /api
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Endpoint para adicionar um novo aluno
    // Ex: POST http://localhost:8080/api/alunos
    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        alunoService.salvar(aluno);
        return ResponseEntity.created(null).body(aluno);
    }

    // Endpoint para listar todos os alunos cadastrados
    // Ex: GET http://localhost:8080/api/alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.deletar(id);
        return ResponseEntity.ok(aluno);
    }


}