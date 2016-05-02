/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.moneda;

import eco.JPAController.MonedaJpaController;
import eco.entidades.Moneda;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class TraerMonedas {
    
    public List <Moneda> traerMonedas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        MonedaJpaController jpa = new MonedaJpaController(emf);
        
        return jpa.findMonedaEntities();
    }
}
