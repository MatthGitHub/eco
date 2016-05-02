/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.JPAController;

import eco.JPAController.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import eco.entidades.Producto;
import eco.entidades.Senias;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class SeniasJpaController implements Serializable {

    public SeniasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Senias senias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto fkProducto = senias.getFkProducto();
            if (fkProducto != null) {
                fkProducto = em.getReference(fkProducto.getClass(), fkProducto.getIdProducto());
                senias.setFkProducto(fkProducto);
            }
            em.persist(senias);
            if (fkProducto != null) {
                fkProducto.getSeniasCollection().add(senias);
                fkProducto = em.merge(fkProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Senias senias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Senias persistentSenias = em.find(Senias.class, senias.getIdSenia());
            Producto fkProductoOld = persistentSenias.getFkProducto();
            Producto fkProductoNew = senias.getFkProducto();
            if (fkProductoNew != null) {
                fkProductoNew = em.getReference(fkProductoNew.getClass(), fkProductoNew.getIdProducto());
                senias.setFkProducto(fkProductoNew);
            }
            senias = em.merge(senias);
            if (fkProductoOld != null && !fkProductoOld.equals(fkProductoNew)) {
                fkProductoOld.getSeniasCollection().remove(senias);
                fkProductoOld = em.merge(fkProductoOld);
            }
            if (fkProductoNew != null && !fkProductoNew.equals(fkProductoOld)) {
                fkProductoNew.getSeniasCollection().add(senias);
                fkProductoNew = em.merge(fkProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = senias.getIdSenia();
                if (findSenias(id) == null) {
                    throw new NonexistentEntityException("The senias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Senias senias;
            try {
                senias = em.getReference(Senias.class, id);
                senias.getIdSenia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The senias with id " + id + " no longer exists.", enfe);
            }
            Producto fkProducto = senias.getFkProducto();
            if (fkProducto != null) {
                fkProducto.getSeniasCollection().remove(senias);
                fkProducto = em.merge(fkProducto);
            }
            em.remove(senias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Senias> findSeniasEntities() {
        return findSeniasEntities(true, -1, -1);
    }

    public List<Senias> findSeniasEntities(int maxResults, int firstResult) {
        return findSeniasEntities(false, maxResults, firstResult);
    }

    private List<Senias> findSeniasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Senias.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Senias findSenias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Senias.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeniasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Senias> rt = cq.from(Senias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
