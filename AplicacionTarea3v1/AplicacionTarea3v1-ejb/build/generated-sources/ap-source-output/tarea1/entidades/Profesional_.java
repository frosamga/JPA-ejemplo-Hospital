package tarea1.entidades;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Alerta;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.Departamento;
import tarea1.entidades.Solicitar;
import tarea1.entidades.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Profesional.class)
public class Profesional_ { 

    public static volatile SingularAttribute<Profesional, String> id;
    public static volatile SingularAttribute<Profesional, String> email;
    public static volatile SingularAttribute<Profesional, Usuario> usuario;
    public static volatile ListAttribute<Profesional, Alerta> alerta;
    public static volatile SingularAttribute<Profesional, Date> fechaComienzo;
    public static volatile SingularAttribute<Profesional, Departamento> departamento;
    public static volatile ListAttribute<Profesional, Solicitar> solicitar;
    public static volatile SingularAttribute<Profesional, String> telefono;
    public static volatile SingularAttribute<Profesional, Date> fechaFin;
    public static volatile SingularAttribute<Profesional, DatosPersonales> datosPersonales;

}