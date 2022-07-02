package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Artvendidos;
import modelo.Tipoabarrote;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-17T01:07:34")
@StaticMetamodel(Invabarrote.class)
public class Invabarrote_ { 

    public static volatile SingularAttribute<Invabarrote, Tipoabarrote> tipo;
    public static volatile SingularAttribute<Invabarrote, Integer> idavr;
    public static volatile SingularAttribute<Invabarrote, Double> cantidadtienda;
    public static volatile SingularAttribute<Invabarrote, Double> cantidadbodega;
    public static volatile ListAttribute<Invabarrote, Artvendidos> artvendidosList;
    public static volatile SingularAttribute<Invabarrote, String> nombre;
    public static volatile SingularAttribute<Invabarrote, Double> costounit;
    public static volatile SingularAttribute<Invabarrote, String> unidadmedida;

}