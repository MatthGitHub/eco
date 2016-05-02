/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.servicios.productos;

import eco.entidades.Marca;
import eco.entidades.Moneda;
import eco.entidades.Producto;
import eco.entidades.Proveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class CargarProductoNuevo {

    public void CargarProductoNuevo(String nombre, String codigo,float costo, float precio, Marca marca,
            Proveedor proveedor, String descripcion, Moneda moneda) {
        Producto prod = new Producto();
        prod.setNombre(nombre);
        prod.setCodigo(codigo);
        prod.setCosto(costo);
        prod.setPrecio(precio);
        prod.setFkMoneda(moneda);
        prod.setFkMarca(marca);
        prod.setFkProveedor(proveedor);
        prod.setDescripcion(descripcion);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(prod);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}
