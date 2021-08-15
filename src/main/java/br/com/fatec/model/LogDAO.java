package br.com.fatec.model;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Author: denis
 */

public class LogDAO extends DAO {

    protected static LogDAO instance;

    public LogDAO() {
        super();
    }

    public static LogDAO getInstance() {
        if (instance == null) {
            instance = new LogDAO();
        }
        return instance;
    }

    public void persist(Log log) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(log);
            et.commit();
        } catch (final Exception e) {
            e.printStackTrace();
            et.rollback();
        }
    }

    public List<Log> findAll() {
        return entityManager.createQuery("FROM " + Log.class.getName()).getResultList();
    }

    public void remove(Long id) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            Log logEncontrado = entityManager.find(Log.class, id);
            if (logEncontrado != null) {
                et.begin();
                entityManager.remove(logEncontrado);
                et.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
