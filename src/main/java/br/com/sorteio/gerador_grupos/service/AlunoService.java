package br.com.sorteio.gerador_grupos.service;

import br.com.sorteio.gerador_grupos.dao.AlunoDAO;
import br.com.sorteio.gerador_grupos.model.Aluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired // Injeta nossa classe AlunoDAO para podermos acessar o banco
    private AlunoDAO alunoDAO;

    @Transactional
    public void salvar(Aluno aluno) {
        alunoDAO.salvar(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoDAO.listarTodos();
    }

    public Aluno buscarPorId(Long id) {
        return alunoDAO.buscarPorId(id);
    }

    @Transactional
    public Aluno deletar(Long id) {

        Aluno aluno = buscarPorId(id);
        alunoDAO.deletar(aluno);
        return aluno;
    }

}
