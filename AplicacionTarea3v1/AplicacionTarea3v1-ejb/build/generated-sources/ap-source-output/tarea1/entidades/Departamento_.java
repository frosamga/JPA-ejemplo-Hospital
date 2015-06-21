package tarea1.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tarea1.entidades.CentroMedico;
import tarea1.entidades.Profesional;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-17T22:24:23")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Long> id;
    public static volatile SingularAttribute<Departamento, String> nombre;
    public static volatile SingularAttribute<Departamento, CentroMedico> centro;
    public static volatile SingularAttribute<Departamento, String> telefono;
    public static volatile SingularAttribute<Departamento, Profesional> jefeDepartamento;
    public static volatile ListAttribute<Departamento, Profesional> profesional;

}