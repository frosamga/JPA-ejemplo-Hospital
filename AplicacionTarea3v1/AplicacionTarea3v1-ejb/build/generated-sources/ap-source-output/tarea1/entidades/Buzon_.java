package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.TipoMensaje;
import tarea1.entidades.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Buzon.class)
public class Buzon_ { 

    public static volatile SingularAttribute<Buzon, Long> id;
    public static volatile SingularAttribute<Buzon, Timestamp> fecha;
    public static volatile SingularAttribute<Buzon, String> texto_mensaje;
    public static volatile SingularAttribute<Buzon, TipoMensaje> tipo_mensaje;
    public static volatile SingularAttribute<Buzon, Usuario> emisor;

}