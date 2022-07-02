package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Artvendidosali;
import modelo.Tipoalimfresco;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-17T01:07:34")
@StaticMetamodel(Invalimento.class)
public class Invalimento_ { 

    public static volatile SingularAttribute<Invalimento, Integer> idalim;
    public static volatile SingularAttribute<Invalimento, Tipoalimfresco> tipo;
    public static volatile ListAttribute<Invalimento, Artvendidosali> artvendidosaliList;
    public static volatile SingularAttribute<Invalimento, Double> cantidadtienda;
    public static volatile SingularAttribute<Invalimento, Double> cantidadbodega;
    public static volatile SingularAttribute<Invalimento, String> nombre;
    public static volatile SingularAttribute<Invalimento, Double> costounit;
    public static volatile SingularAttribute<Invalimento, String> unidadmedida;

}