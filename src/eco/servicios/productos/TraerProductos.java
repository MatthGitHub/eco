/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.servicios.productos;

import eco.JPAController.ProductoJpaController;
import eco.entidades.Marca;
import eco.entidades.Producto;
import eco.entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class TraerProductos {
    private ProductoJpaController jpa;
    private List<Producto> miLista;

    public List<Producto> TraerProductos() {
        Producto ub = new Producto();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();
        jpa = new ProductoJpaController(emf);

        miLista = jpa.findProductoEntities();
        return miLista;
    }
    /**
     * Trae un producto por us ID
     * @param id
     * @return 
     */
    public Producto TraerUnProducto(int id) {
        Producto ub = new Producto();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        jpa = new ProductoJpaController(emf);

        ub = jpa.findProducto(id);
        return ub;
    }
    
    
    
    /**
     * Trae los productos por marca
     * @param marca
     * @return una lista de todos los productos con esa marca
     */
    public List<Producto> TraerProductosMarca(Marca marca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        jpa = new ProductoJpaController(emf);

        miLista = jpa.findProductoEntities();
        List <Producto> aux;
        aux = new ArrayList<>();
        for(int i = 0 ; i < miLista.size(); i++){
            if(miLista.get(i).getFkMarca().equals(marca)){
                aux.add(miLista.get(i));
            }
        }
        
        return aux;
    }
    /**
     * Trae una lista de productos por proveedor
     * @param prov
     * @return 
     */
    public List<Producto> TraerProductosProveedor(Proveedor prov) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        jpa = new ProductoJpaController(emf);

        miLista = jpa.findProductoEntities();
        List <Producto> aux;
        aux = new ArrayList<>();
        
        for(int i = 0 ; i < miLista.size(); i++){
            if(miLista.get(i).getFkProveedor().equals(prov)){
                aux.add(miLista.get(i));
            }
        }
        
        return aux;
    }
    /**
     * Trae una lista de productos por proveedor y marca
     * @param prov
     * @param marca
     * @return 
     */
    public List<Producto> TraerProductosProveedorMarca(Proveedor prov,Marca marca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        jpa = new ProductoJpaController(emf);

        miLista = jpa.findProductoEntities();
        List <Producto> aux;
        aux = new ArrayList<>();
        
        for(int i = 0 ; i < miLista.size(); i++){
            if((miLista.get(i).getFkProveedor().equals(prov))&&(miLista.get(i).getFkMarca().equals(marca))){
                aux.add(miLista.remove(i));
            }
        }
        
        return aux;
    }
    
}
