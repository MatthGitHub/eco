/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.proveedores;

import eco.JPAController.ProveedorJpaController;
import eco.entidades.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class TraerProveedores {
    private ProveedorJpaController jpa;
    private List<Proveedor> miLista;

    public List<Proveedor> TraerProveedores() {
        Proveedor ub = new Proveedor();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new ProveedorJpaController(emf);

        miLista = jpa.findProveedorEntities();
        return miLista;
    }
    
    public Proveedor traerProveedor(int prov){
        Proveedor ub;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new ProveedorJpaController(emf);
        
        ub = jpa.findProveedor(prov);
        return ub;
    }
}
