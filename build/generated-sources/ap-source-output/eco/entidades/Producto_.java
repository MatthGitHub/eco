package eco.entidades;

import eco.entidades.Marca;
import eco.entidades.Moneda;
import eco.entidades.Proveedor;
import eco.entidades.Senias;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:36:28")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, String> codigo;
    public static volatile CollectionAttribute<Producto, Senias> seniasCollection;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, Marca> fkMarca;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Float> costo;
    public static volatile SingularAttribute<Producto, Moneda> fkMoneda;
    public static volatile SingularAttribute<Producto, Proveedor> fkProveedor;

}