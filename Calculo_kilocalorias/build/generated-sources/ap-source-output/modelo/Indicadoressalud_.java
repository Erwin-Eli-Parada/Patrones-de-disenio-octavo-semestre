package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Tipoactividad;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-02T09:25:18")
@StaticMetamodel(Indicadoressalud.class)
public class Indicadoressalud_ { 

    public static volatile SingularAttribute<Indicadoressalud, Date> fecha;
    public static volatile SingularAttribute<Indicadoressalud, Integer> cintura;
    public static volatile SingularAttribute<Indicadoressalud, Integer> idindsalud;
    public static volatile SingularAttribute<Indicadoressalud, Double> peso;
    public static volatile SingularAttribute<Indicadoressalud, Usuario> usuario;
    public static volatile SingularAttribute<Indicadoressalud, Integer> cadera;
    public static volatile SingularAttribute<Indicadoressalud, Tipoactividad> tipoactividad;

}