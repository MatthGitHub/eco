/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.productos;

import eco.JPAController.ProductoJpaController;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class EliminarProducto {
    ProductoJpaController jpa;
    
    public EliminarProducto(int elim) throws NonexistentEntityException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new ProductoJpaController(emf);

        jpa.destroy(elim);
    }
}
