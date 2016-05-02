/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.proveedores;

import eco.entidades.Proveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class CargarProveedorNuevo {
    
    
    public CargarProveedorNuevo(String nombre) {

        Proveedor prov = new Proveedor();
        prov.setNombre(nombre);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prov);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();

        }
    }
}
