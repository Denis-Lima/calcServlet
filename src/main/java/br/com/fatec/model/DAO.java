package br.com.fatec.model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: denis
 */

public abstract class DAO {
    protected EntityManager entityManager;

    protected DAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("calcServlet");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }
}
