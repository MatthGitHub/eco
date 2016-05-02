/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.marcas;

import eco.entidades.Marca;
import eco.entidades.Tipos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class CargarMarcaNueva {
    
    public CargarMarcaNueva(String nombre, Tipos fkTipo) {

        Marca mar = new Marca();
        mar.setNombre(nombre);
        mar.setFkTipo(fkTipo);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mar);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();

        }
    }
    
}
