package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Invabarrote;
import modelo.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-17T01:07:34")
@StaticMetamodel(Artvendidos.class)
public class Artvendidos_ { 

    public static volatile SingularAttribute<Artvendidos, Integer> idventa;
    public static volatile SingularAttribute<Artvendidos, Venta> venta;
    public static volatile SingularAttribute<Artvendidos, Integer> cantidad;
    public static volatile SingularAttribute<Artvendidos, Invabarrote> articulo;

}