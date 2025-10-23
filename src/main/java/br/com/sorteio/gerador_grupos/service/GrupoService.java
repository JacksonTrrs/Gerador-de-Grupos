package br.com.sorteio.gerador_grupos.service;

import br.com.sorteio.gerador_grupos.dao.GrupoDAO;
import br.com.sorteio.gerador_grupos.model.Grupo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoDAO grupoDAO;

    @Transactional
    public void salvar(Grupo grupo) {
        grupoDAO.salvar(grupo);
    }

    public List<Grupo> listarTodos() {
        return grupoDAO.listarTodos();
    }

    public Grupo buscarPorId(Long id) {
        return grupoDAO.buscarPorId(id);
    }

    @Transactional
    public Grupo deletar(Long id) {
        Grupo grupo = buscarPorId(id);
        grupoDAO.deletar(grupo);
        return grupo;
    }
}