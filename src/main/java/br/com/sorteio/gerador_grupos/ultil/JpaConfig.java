package br.com.sorteio.gerador_grupos.ultil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // Habilita o gerenciamento de transação do Spring (@Transactional)
public class JpaConfig {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sorteio-pu");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){

        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }
}


