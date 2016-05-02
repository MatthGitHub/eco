/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.servicios.marcas;

import eco.JPAController.MarcaJpaController;
import eco.entidades.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matias Benditti
 */
public class TraerMarcas {

    private MarcaJpaController jpa;
    private List<Marca> miLista;

    public List<Marca> TraerMarcas() {
        Marca ub = new Marca();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new MarcaJpaController(emf);

        miLista = jpa.findMarcaEntities();
        return miLista;
    }
}
