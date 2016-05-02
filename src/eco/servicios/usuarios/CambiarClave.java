/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.servicios.usuarios;

import eco.JPAController.UsuariosJpaController;
import eco.entidades.Usuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class CambiarClave {

    public CambiarClave(Usuarios usuario) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        UsuariosJpaController jpa = new UsuariosJpaController(emf);
        
        try {
            jpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(CambiarClave.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
