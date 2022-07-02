package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Artvendidos;
import modelo.Artvendidosali;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-17T01:07:34")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, String> empleado;
    public static volatile ListAttribute<Venta, Artvendidosali> artvendidosaliList;
    public static volatile SingularAttribute<Venta, Boolean> efectivo;
    public static volatile ListAttribute<Venta, Artvendidos> artvendidosList;

}