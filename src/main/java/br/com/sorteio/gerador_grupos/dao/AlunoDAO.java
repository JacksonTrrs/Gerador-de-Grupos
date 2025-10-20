package br.com.sorteio.gerador_grupos.dao;


import br.com.sorteio.gerador_grupos.model.Aluno;
import br.com.sorteio.gerador_grupos.ultil.JpaConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 1. Marca esta classe como um componente de persistência do Spring
public class AlunoDAO {

    @PersistenceContext // 2. Injeta o EntityManager, o coração do JPA
    private EntityManager entityManager;

    @Transactional // 3. O Spring gerencia a transação (begin, commit, rollback)
    public void salvar(Aluno aluno) {

        EntityManager em = JpaConfig.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();

        }catch(Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();

        }finally {

            em.close();
        }

        entityManager.persist(aluno); // 4. O metodo persist() salva uma nova entidade
    }

    public List<Aluno> listarTodos() {
        // 5. Usa JPQL (Java Persistence Query Language) para buscar os alunos
        String jpql = "SELECT a FROM Aluno a";
        return entityManager.createQuery(jpql, Aluno.class).getResultList();
    }
}
