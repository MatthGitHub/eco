package eco.entidades;

import eco.entidades.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:36:28")
@StaticMetamodel(Senias.class)
public class Senias_ { 

    public static volatile SingularAttribute<Senias, String> apellido;
    public static volatile SingularAttribute<Senias, String> nombre;
    public static volatile SingularAttribute<Senias, String> total;
    public static volatile SingularAttribute<Senias, Date> fecha;
    public static volatile SingularAttribute<Senias, Date> vencimiento;
    public static volatile SingularAttribute<Senias, Producto> fkProducto;
    public static volatile SingularAttribute<Senias, String> telefono;
    public static volatile SingularAttribute<Senias, Integer> idSenia;
    public static volatile SingularAttribute<Senias, String> dni;
    public static volatile SingularAttribute<Senias, String> montoSeniado;

}