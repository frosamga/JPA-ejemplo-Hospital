package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.DatosPersonales;
import tarea1.entidades.HistoriaClinica;
import tarea1.entidades.Notificacion;
import tarea1.entidades.Ocupa;
import tarea1.entidades.Profesional;
import tarea1.entidades.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile ListAttribute<Paciente, Ocupa> ocupacion;
    public static volatile ListAttribute<Paciente, HistoriaClinica> historialMedico;
    public static volatile SingularAttribute<Paciente, String> numero_ss;
    public static volatile SingularAttribute<Paciente, Usuario> usuario;
    public static volatile SingularAttribute<Paciente, CentroMedico> centroAsignado;
    public static volatile ListAttribute<Paciente, Notificacion> notificaciones;
    public static volatile SingularAttribute<Paciente, DatosPersonales> datosPersonales;
    public static volatile SingularAttribute<Paciente, Profesional> medicoAsignado;

}