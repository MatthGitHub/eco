/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.usuarios;

import eco.JPAController.UsuariosJpaController;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Usuarios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class EliminarUsuario {
    UsuariosJpaController jpa;
    
    public EliminarUsuario(int elim) throws NonexistentEntityException{
        Usuarios ub = new Usuarios();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new UsuariosJpaController(emf);

        jpa.destroy(elim);
    }
    
}


