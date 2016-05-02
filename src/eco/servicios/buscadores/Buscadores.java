/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.buscadores;

import eco.entidades.Marca;
import eco.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class Buscadores {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
    private static EntityManager em = emf.createEntityManager();
    private static Query q;
    private static List <Marca> miListaM = new ArrayList<>();
    private static List <Producto> miListaProd = new ArrayList<>();
    
    public static List <Marca> buscarMarcas(String patron){
        q = em.createQuery("SELECT * FROM marca WHERE nombre LIKE:= patron");
        q.setParameter("patron", "%"+ patron+"%");
        miListaM = q.getResultList();
        return miListaM;
    }
 
    public static List <Producto> buscarProductos(String patron){
        q = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :patron OR p.codigo LIKE :patron");
        q.setParameter("patron", "%"+ patron+"%");
        miListaProd = q.getResultList();
        return miListaProd;
    }
    
    
}
