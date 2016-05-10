/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.modelo.dao;

import afp.modelo.Categoria;
import afp.util.FabricaDeEntidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jw
 */
public class CategoriaDAO implements IDAO<Categoria> {

    EntityManagerFactory emf;

    public CategoriaDAO() {
        emf = FabricaDeEntidades.getEntityManagerFactory();
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void insert(Categoria c) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Categoria update(Categoria c) {
        EntityManager em = getEntityManager();
        Categoria c2 = null;
        try {
            em.getTransaction().begin();
            c2 = em.merge(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return c2;
    }

    @Override
    public void delete(Categoria c) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Categoria> findAll() {
        EntityManager em = getEntityManager();
        List<Categoria> list = null;
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT c FROM Categoria c").getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public Categoria findById(int id) {
        EntityManager em = getEntityManager();
        Categoria c = null;
        try {
            em.getTransaction().begin();
            c = em.find(Categoria.class, id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return c;
    }
}
