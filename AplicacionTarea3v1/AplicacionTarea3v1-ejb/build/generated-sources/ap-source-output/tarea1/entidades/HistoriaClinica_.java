package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Paciente;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(HistoriaClinica.class)
public class HistoriaClinica_ { 

    public static volatile SingularAttribute<HistoriaClinica, Long> id;
    public static volatile SingularAttribute<HistoriaClinica, Paciente> paciente;
    public static volatile SingularAttribute<HistoriaClinica, Timestamp> fecha;
    public static volatile SingularAttribute<HistoriaClinica, String> texto;
    public static volatile SingularAttribute<HistoriaClinica, Profesional> profesional;

}