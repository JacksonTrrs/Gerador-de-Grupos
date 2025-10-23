package br.com.sorteio.gerador_grupos.dao;


import br.com.sorteio.gerador_grupos.model.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository // 1. Marca esta classe como um componente de persistência do Spring
public class AlunoDAO {

    @PersistenceContext // 2. Injeta o EntityManager, o coração do JPA
    private EntityManager entityManager;

    @Transactional // 3. O Spring gerencia a transação (begin, commit, rollback)
    public void salvar(Aluno aluno) {

        // 1. Criar a query para buscar um aluno pelo nome
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(a) FROM Aluno a WHERE a.nome = :nome", Long.class);
        query.setParameter("nome", aluno.getNome());

        // 2. Executar a consulta para verificar se já existe algum aluno com esse nome
        Long count = query.getSingleResult();

        if (count > 0) {
            // 3. Lançar uma exceção para interromper o cadastro
            throw new IllegalArgumentException("Já existe um aluno cadastrado com o nome: " + aluno.getNome());
        }

        // 4. O metodo persist() salva uma nova entidade, se o nome não for duplicado
        entityManager.persist(aluno);
    }

    public List<Aluno> listarTodos() {
        // 5. Usa JPQL (Java Persistence Query Language) para buscar os alunos
        String jpql = "SELECT a FROM Aluno a";
        return entityManager.createQuery(jpql, Aluno.class).getResultList();
    }

    public Aluno buscarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }

    @Transactional
    public void deletar(Aluno aluno) {

        entityManager.remove(aluno);
    }
}