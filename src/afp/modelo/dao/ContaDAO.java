package afp.modelo.dao;

import afp.util.FabricaDeEntidades;
import afp.modelo.Conta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ContaDAO implements IDAO<Conta> {

    EntityManagerFactory emf;

    public ContaDAO() {
        emf = FabricaDeEntidades.getEntityManagerFactory();
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void insert(Conta c) {
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
    public Conta update(Conta c) {
        EntityManager em = getEntityManager();
        Conta c2 = null;
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
    public void delete(Conta c) {
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
    public List<Conta> findAll() {
        EntityManager em = getEntityManager();
        List<Conta> list = null;
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT c FROM Conta c").getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public Conta findById(int id) {
        EntityManager em = getEntityManager();
        Conta c = null;
        try {
            em.getTransaction().begin();
            c = em.find(Conta.class, id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return c;
    }
}
