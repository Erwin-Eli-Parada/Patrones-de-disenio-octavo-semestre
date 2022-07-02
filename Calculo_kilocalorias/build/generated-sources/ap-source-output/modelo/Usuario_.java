package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Indicadoressalud;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-02T09:25:18")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Indicadoressalud> indicadoressaludList;
    public static volatile SingularAttribute<Usuario, Double> estutura;
    public static volatile SingularAttribute<Usuario, Date> fechanacimiento;
    public static volatile SingularAttribute<Usuario, String> contrasenia;
    public static volatile SingularAttribute<Usuario, Character> sexo;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;

}