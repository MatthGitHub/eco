package eco.entidades;

import eco.entidades.Marca;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:36:28")
@StaticMetamodel(Tipos.class)
public class Tipos_ { 

    public static volatile SingularAttribute<Tipos, String> nombre;
    public static volatile SingularAttribute<Tipos, Integer> idTipo;
    public static volatile CollectionAttribute<Tipos, Marca> marcaCollection;

}