package br.com.fatec.model;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Author: Denis Lima
 */

public class ClassificacaoDAO extends DAO {
    protected static ClassificacaoDAO instance;

    public ClassificacaoDAO() {
        super();
    }

    public static ClassificacaoDAO getInstance() {
        if (instance == null) {
            instance = new ClassificacaoDAO();
        }
        return instance;
    }

    public void persist(Classificacao classificacao) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(classificacao);
            et.commit();
        } catch (final Exception e) {
            e.printStackTrace();
            et.rollback();
        }
    }

    public List<Classificacao> findAll() {
        return entityManager.createQuery("FROM " + Classificacao.class.getName()).getResultList();
    }

    public void remove(Long id) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            Classificacao classificacao = entityManager.find(Classificacao.class, id);
            if (classificacao != null) {
                et.begin();
                entityManager.remove(classificacao);
                et.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
