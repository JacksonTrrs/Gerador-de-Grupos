package br.com.sorteio.gerador_grupos.ultil;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;




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


