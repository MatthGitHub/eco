/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.tipos;

import eco.JPAController.TiposJpaController;
import eco.entidades.Tipos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matias Benditti
 */
public class TraerTipos {
    private TiposJpaController jpa;
    private List<Tipos> miLista;

    public List<Tipos> TraerTipos() {
        Tipos ub = new Tipos();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new TiposJpaController(emf);

        miLista = jpa.findTiposEntities();
        return miLista;
    }
}
