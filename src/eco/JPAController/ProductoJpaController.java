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
import eco.entidades.Marca;
import eco.entidades.Proveedor;
import eco.entidades.Moneda;
import eco.entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Marca fkMarca = producto.getFkMarca();
            if (fkMarca != null) {
                fkMarca = em.getReference(fkMarca.getClass(), fkMarca.getIdMarca());
                producto.setFkMarca(fkMarca);
            }
            Proveedor fkProveedor = producto.getFkProveedor();
            if (fkProveedor != null) {
                fkProveedor = em.getReference(fkProveedor.getClass(), fkProveedor.getIdProveedor());
                producto.setFkProveedor(fkProveedor);
            }
            Moneda fkMoneda = producto.getFkMoneda();
            if (fkMoneda != null) {
                fkMoneda = em.getReference(fkMoneda.getClass(), fkMoneda.getIdMoneda());
                producto.setFkMoneda(fkMoneda);
            }
            em.persist(producto);
            if (fkMarca != null) {
                fkMarca.getProductoCollection().add(producto);
                fkMarca = em.merge(fkMarca);
            }
            if (fkProveedor != null) {
                fkProveedor.getProductoCollection().add(producto);
                fkProveedor = em.merge(fkProveedor);
            }
            if (fkMoneda != null) {
                fkMoneda.getProductoCollection().add(producto);
                fkMoneda = em.merge(fkMoneda);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Marca fkMarcaOld = persistentProducto.getFkMarca();
            Marca fkMarcaNew = producto.getFkMarca();
            Proveedor fkProveedorOld = persistentProducto.getFkProveedor();
            Proveedor fkProveedorNew = producto.getFkProveedor();
            Moneda fkMonedaOld = persistentProducto.getFkMoneda();
            Moneda fkMonedaNew = producto.getFkMoneda();
            if (fkMarcaNew != null) {
                fkMarcaNew = em.getReference(fkMarcaNew.getClass(), fkMarcaNew.getIdMarca());
                producto.setFkMarca(fkMarcaNew);
            }
            if (fkProveedorNew != null) {
                fkProveedorNew = em.getReference(fkProveedorNew.getClass(), fkProveedorNew.getIdProveedor());
                producto.setFkProveedor(fkProveedorNew);
            }
            if (fkMonedaNew != null) {
                fkMonedaNew = em.getReference(fkMonedaNew.getClass(), fkMonedaNew.getIdMoneda());
                producto.setFkMoneda(fkMonedaNew);
            }
            producto = em.merge(producto);
            if (fkMarcaOld != null && !fkMarcaOld.equals(fkMarcaNew)) {
                fkMarcaOld.getProductoCollection().remove(producto);
                fkMarcaOld = em.merge(fkMarcaOld);
            }
            if (fkMarcaNew != null && !fkMarcaNew.equals(fkMarcaOld)) {
                fkMarcaNew.getProductoCollection().add(producto);
                fkMarcaNew = em.merge(fkMarcaNew);
            }
            if (fkProveedorOld != null && !fkProveedorOld.equals(fkProveedorNew)) {
                fkProveedorOld.getProductoCollection().remove(producto);
                fkProveedorOld = em.merge(fkProveedorOld);
            }
            if (fkProveedorNew != null && !fkProveedorNew.equals(fkProveedorOld)) {
                fkProveedorNew.getProductoCollection().add(producto);
                fkProveedorNew = em.merge(fkProveedorNew);
            }
            if (fkMonedaOld != null && !fkMonedaOld.equals(fkMonedaNew)) {
                fkMonedaOld.getProductoCollection().remove(producto);
                fkMonedaOld = em.merge(fkMonedaOld);
            }
            if (fkMonedaNew != null && !fkMonedaNew.equals(fkMonedaOld)) {
                fkMonedaNew.getProductoCollection().add(producto);
                fkMonedaNew = em.merge(fkMonedaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Marca fkMarca = producto.getFkMarca();
            if (fkMarca != null) {
                fkMarca.getProductoCollection().remove(producto);
                fkMarca = em.merge(fkMarca);
            }
            Proveedor fkProveedor = producto.getFkProveedor();
            if (fkProveedor != null) {
                fkProveedor.getProductoCollection().remove(producto);
                fkProveedor = em.merge(fkProveedor);
            }
            Moneda fkMoneda = producto.getFkMoneda();
            if (fkMoneda != null) {
                fkMoneda.getProductoCollection().remove(producto);
                fkMoneda = em.merge(fkMoneda);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
