package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Invalimento;
import modelo.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-17T01:07:34")
@StaticMetamodel(Artvendidosali.class)
public class Artvendidosali_ { 

    public static volatile SingularAttribute<Artvendidosali, Integer> idventa;
    public static volatile SingularAttribute<Artvendidosali, Venta> venta;
    public static volatile SingularAttribute<Artvendidosali, Integer> cantidad;
    public static volatile SingularAttribute<Artvendidosali, Invalimento> articulo;

}