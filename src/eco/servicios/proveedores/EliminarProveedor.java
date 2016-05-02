/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.proveedores;

import eco.JPAController.ProveedorJpaController;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Proveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class EliminarProveedor {
        ProveedorJpaController jpa;
    
    public EliminarProveedor(int elim) throws NonexistentEntityException{
        Proveedor ub = new Proveedor();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new ProveedorJpaController(emf);

        jpa.destroy(elim);
    }
    
}
