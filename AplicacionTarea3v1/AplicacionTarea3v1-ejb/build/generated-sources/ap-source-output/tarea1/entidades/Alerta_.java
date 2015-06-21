package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Alerta.class)
public class Alerta_ { 

    public static volatile SingularAttribute<Alerta, Long> id;
    public static volatile SingularAttribute<Alerta, Timestamp> fecha;
    public static volatile SingularAttribute<Alerta, String> asunto;
    public static volatile SingularAttribute<Alerta, String> lugar;
    public static volatile SingularAttribute<Alerta, String> descripcion;
    public static volatile SingularAttribute<Alerta, Profesional> profesional;

}