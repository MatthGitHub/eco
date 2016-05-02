/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.servicios.moneda;

import eco.JPAController.MonedaJpaController;
import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Moneda;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class ModificarMoneda {
    
    public boolean modificarMoneda(Moneda aModif){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        MonedaJpaController jpa = new MonedaJpaController(emf);
        
        try {
            jpa.edit(aModif);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ModificarMoneda.class.getName()).log(Level.SEVERE, "No existe la moneda - ModificarMoneda", ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ModificarMoneda.class.getName()).log(Level.SEVERE, "Error en ModificarMoneda - edit", ex);
            return false;
        }
        return true;
    }
}
