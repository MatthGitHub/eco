package eco.entidades;

import eco.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:36:28")
@StaticMetamodel(Moneda.class)
public class Moneda_ { 

    public static volatile SingularAttribute<Moneda, String> nombre;
    public static volatile SingularAttribute<Moneda, Integer> idMoneda;
    public static volatile SingularAttribute<Moneda, Float> costo;
    public static volatile CollectionAttribute<Moneda, Producto> productoCollection;

}