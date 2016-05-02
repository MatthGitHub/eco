/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.marcas;

import eco.JPAController.MarcaJpaController;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Marca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class EliminarMarca {
    MarcaJpaController jpa;
    
    public EliminarMarca(int elim) throws NonexistentEntityException{
        Marca ub = new Marca();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new MarcaJpaController(emf);

        jpa.destroy(elim);
    }
    
}
