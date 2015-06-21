package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Ocupa;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Cama.class)
public class Cama_ { 

    public static volatile SingularAttribute<Cama, Long> id;
    public static volatile SingularAttribute<Cama, Boolean> libre;
    public static volatile SingularAttribute<Cama, CentroMedico> centro;
    public static volatile ListAttribute<Cama, Ocupa> ocupa;
    public static volatile SingularAttribute<Cama, String> num_cama;

}