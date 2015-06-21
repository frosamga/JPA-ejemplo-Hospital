package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Cama;
import tarea1.entidades.Paciente;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Ocupa.class)
public class Ocupa_ { 

    public static volatile SingularAttribute<Ocupa, Long> id;
    public static volatile SingularAttribute<Ocupa, Paciente> paciente;
    public static volatile SingularAttribute<Ocupa, Timestamp> fecha;
    public static volatile SingularAttribute<Ocupa, Cama> cama;

}