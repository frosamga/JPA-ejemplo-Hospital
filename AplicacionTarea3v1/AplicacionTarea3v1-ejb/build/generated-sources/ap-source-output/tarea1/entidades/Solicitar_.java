package tarea1.entidades;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.Material;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Solicitar.class)
public class Solicitar_ { 

    public static volatile SingularAttribute<Solicitar, Long> id;
    public static volatile SingularAttribute<Solicitar, Timestamp> fecha;
    public static volatile SingularAttribute<Solicitar, Integer> cantidad;
    public static volatile SingularAttribute<Solicitar, Profesional> profesional;
    public static volatile SingularAttribute<Solicitar, Material> material;

}