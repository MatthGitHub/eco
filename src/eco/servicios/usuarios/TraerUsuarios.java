/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.usuarios;

import eco.JPAController.UsuariosJpaController;
import eco.entidades.Usuarios;
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
public class TraerUsuarios {
    private UsuariosJpaController jpa;
    
    public List <Usuarios> traerUsuarios(){
        List <Usuarios> miLista = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        UsuariosJpaController jpa = new UsuariosJpaController(emf);
        
        miLista = jpa.findUsuariosEntities();
        return miLista;
        
    }
    
    public Usuarios traerUnUsuario(String nombre,String clave) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.nombre = (:nombre)"
                                 +" AND u.clave = (:clave)");
        q.setParameter("nombre", nombre);
        q.setParameter("clave", clave);
        
        return (Usuarios) q.getSingleResult();
    }
    
    public Usuarios traerUnUsuario(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new UsuariosJpaController(emf);
        
        return jpa.findUsuarios(id);
    }
    
}
