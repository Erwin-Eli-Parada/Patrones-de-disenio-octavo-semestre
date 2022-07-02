package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Indicadoressalud;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-02T09:25:18")
@StaticMetamodel(Tipoactividad.class)
public class Tipoactividad_ { 

    public static volatile SingularAttribute<Tipoactividad, String> descripcion;
    public static volatile ListAttribute<Tipoactividad, Indicadoressalud> indicadoressaludList;
    public static volatile SingularAttribute<Tipoactividad, String> actividades;
    public static volatile SingularAttribute<Tipoactividad, Integer> idtac;

}