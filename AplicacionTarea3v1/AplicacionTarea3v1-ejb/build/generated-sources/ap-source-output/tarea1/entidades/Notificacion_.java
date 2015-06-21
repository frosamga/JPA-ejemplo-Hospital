package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Notificacion.class)
public class Notificacion_ { 

    public static volatile SingularAttribute<Notificacion, Long> id;
    public static volatile SingularAttribute<Notificacion, Paciente> paciente;
    public static volatile SingularAttribute<Notificacion, Timestamp> fecha;
    public static volatile SingularAttribute<Notificacion, String> tipo;
    public static volatile SingularAttribute<Notificacion, String> descripcion;
    public static volatile SingularAttribute<Notificacion, Profesional> profesional;
    public static volatile SingularAttribute<Notificacion, CentroMedico> centroMedico;

}