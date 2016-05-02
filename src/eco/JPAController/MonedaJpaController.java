/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.JPAController;

import eco.JPAController.exceptions.IllegalOrphanException;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Moneda;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import eco.entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class MonedaJpaController implements Serializable {

    public MonedaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moneda moneda) {
        if (moneda.getProductoCollection() == null) {
            moneda.setProductoCollection(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Producto> attachedProductoCollection = new ArrayList<Producto>();
            for (Producto productoCollectionProductoToAttach : moneda.getProductoCollection()) {
                productoCollectionProductoToAttach = em.getReference(productoCollectionProductoToAttach.getClass(), productoCollectionProductoToAttach.getIdProducto());
                attachedProductoCollection.add(productoCollectionProductoToAttach);
            }
            moneda.setProductoCollection(attachedProductoCollection);
            em.persist(moneda);
            for (Producto productoCollectionProducto : moneda.getProductoCollection()) {
                Moneda oldFkMonedaOfProductoCollectionProducto = productoCollectionProducto.getFkMoneda();
                productoCollectionProducto.setFkMoneda(moneda);
                productoCollectionProducto = em.merge(productoCollectionProducto);
                if (oldFkMonedaOfProductoCollectionProducto != null) {
                    oldFkMonedaOfProductoCollectionProducto.getProductoCollection().remove(productoCollectionProducto);
                    oldFkMonedaOfProductoCollectionProducto = em.merge(oldFkMonedaOfProductoCollectionProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moneda moneda) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moneda persistentMoneda = em.find(Moneda.class, moneda.getIdMoneda());
            Collection<Producto> productoCollectionOld = persistentMoneda.getProductoCollection();
            Collection<Producto> productoCollectionNew = moneda.getProductoCollection();
            List<String> illegalOrphanMessages = null;
            for (Producto productoCollectionOldProducto : productoCollectionOld) {
                if (!productoCollectionNew.contains(productoCollectionOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoCollectionOldProducto + " since its fkMoneda field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Producto> attachedProductoCollectionNew = new ArrayList<Producto>();
            for (Producto productoCollectionNewProductoToAttach : productoCollectionNew) {
                productoCollectionNewProductoToAttach = em.getReference(productoCollectionNewProductoToAttach.getClass(), productoCollectionNewProductoToAttach.getIdProducto());
                attachedProductoCollectionNew.add(productoCollectionNewProductoToAttach);
            }
            productoCollectionNew = attachedProductoCollectionNew;
            moneda.setProductoCollection(productoCollectionNew);
            moneda = em.merge(moneda);
            for (Producto productoCollectionNewProducto : productoCollectionNew) {
                if (!productoCollectionOld.contains(productoCollectionNewProducto)) {
                    Moneda oldFkMonedaOfProductoCollectionNewProducto = productoCollectionNewProducto.getFkMoneda();
                    productoCollectionNewProducto.setFkMoneda(moneda);
                    productoCollectionNewProducto = em.merge(productoCollectionNewProducto);
                    if (oldFkMonedaOfProductoCollectionNewProducto != null && !oldFkMonedaOfProductoCollectionNewProducto.equals(moneda)) {
                        oldFkMonedaOfProductoCollectionNewProducto.getProductoCollection().remove(productoCollectionNewProducto);
                        oldFkMonedaOfProductoCollectionNewProducto = em.merge(oldFkMonedaOfProductoCollectionNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moneda.getIdMoneda();
                if (findMoneda(id) == null) {
                    throw new NonexistentEntityException("The moneda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moneda moneda;
            try {
                moneda = em.getReference(Moneda.class, id);
                moneda.getIdMoneda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moneda with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Producto> productoCollectionOrphanCheck = moneda.getProductoCollection();
            for (Producto productoCollectionOrphanCheckProducto : productoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Moneda (" + moneda + ") cannot be destroyed since the Producto " + productoCollectionOrphanCheckProducto + " in its productoCollection field has a non-nullable fkMoneda field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(moneda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moneda> findMonedaEntities() {
        return findMonedaEntities(true, -1, -1);
    }

    public List<Moneda> findMonedaEntities(int maxResults, int firstResult) {
        return findMonedaEntities(false, maxResults, firstResult);
    }

    private List<Moneda> findMonedaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moneda.class));
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

    public Moneda findMoneda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moneda.class, id);
        } finally {
            em.close();
        }
    }

    public int getMonedaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moneda> rt = cq.from(Moneda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
