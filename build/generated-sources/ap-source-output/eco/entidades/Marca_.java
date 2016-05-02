package eco.entidades;

import eco.entidades.Producto;
import eco.entidades.Tipos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:36:28")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, Integer> idMarca;
    public static volatile SingularAttribute<Marca, String> nombre;
    public static volatile SingularAttribute<Marca, Tipos> fkTipo;
    public static volatile CollectionAttribute<Marca, Producto> productoCollection;

}