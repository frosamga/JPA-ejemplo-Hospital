package tarea1.entidades;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.Direccion;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(DatosPersonales.class)
public class DatosPersonales_ { 

    public static volatile SingularAttribute<DatosPersonales, String> nombre;
    public static volatile SingularAttribute<DatosPersonales, String> apellido2;
    public static volatile SingularAttribute<DatosPersonales, Direccion> direccion;
    public static volatile SingularAttribute<DatosPersonales, Profesional> datosProfesional;
    public static volatile SingularAttribute<DatosPersonales, Paciente> datosPaciente;
    public static volatile SingularAttribute<DatosPersonales, String> apellido1;
    public static volatile SingularAttribute<DatosPersonales, String> telefono;
    public static volatile SingularAttribute<DatosPersonales, String> dni;
    public static volatile SingularAttribute<DatosPersonales, Date> fechaNacimiento;
    public static volatile SingularAttribute<DatosPersonales, String> nacionalidad;

}